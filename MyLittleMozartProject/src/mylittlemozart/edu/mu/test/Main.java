package mylittlemozart.edu.mu.test;

import mylittlemozart.edu.mu.data.MidiCsvParser;
import mylittlemozart.edu.mu.data.MidiEventData;
import mylittlemozart.edu.mu.factory.*;
import mylittlemozart.edu.mu.instrument.*;
import mylittlemozart.edu.mu.pitch.*;

import javax.sound.midi.*;
import java.util.List;

/**
 * Main class for demonstrating the complete My Little Mozart system.
 */
public class Main {

    public static void main(String[] args) {
        try {
            List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("/Users/colepuls/Desktop/eclipse-java/MyLittleMozartProject/src/mylittlemozart/edu/mu/mystery_song.csv");

            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();
            MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            MidiEventFactory factory = factoryAbstract.createFactory();
            InstrumentStrategy bassGuitar = new ElectricBassGuitarStrategy();
            bassGuitar.applyInstrument(track, 0);
            InstrumentStrategy trumpet = new TrumpetStrategy();
            trumpet.applyInstrument(track, 1);
            PitchStrategy pitchStrategy = new HigherPitchStrategy();
       
            for (MidiEventData eventData : midiEvents) {
                int originalNote = eventData.getNote();
                int modifiedNote = pitchStrategy.modifyPitch(originalNote);

                if (eventData.getNoteOnOff() == ShortMessage.NOTE_ON) {
                    track.add(factory.createNoteOn(
                            eventData.getStartEndTick(),
                            modifiedNote,
                            eventData.getVelocity(),
                            eventData.getChannel()
                    ));
                } else {
                    track.add(factory.createNoteOff(
                            eventData.getStartEndTick(),
                            modifiedNote,
                            eventData.getChannel()
                    ));
                }
            }

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();

            while (sequencer.isRunning()) {
                Thread.sleep(100);
            }
            Thread.sleep(500);
            sequencer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
