package mylittlemozart.edu.mu.test;
import javax.sound.midi.*;

public class Main {
	public static void main(String[] args) throws Exception {
	    Sequence sequence = new Sequence(Sequence.PPQ, 24);
	    Track track = sequence.createTrack();
	    List<MidiEventData> events = MidiCsvParser.parseCsv("midi-data.csv");
	    MidiEventFactory factory = new StandardMidiEventFactory();
	    InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
	    instrumentStrategy.applyInstrument(track, 0);
	    for (MidiEventData event : events) {
	        if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
	            track.add(factory.createNoteOn(event.getStartEndTick(), event.getNote(),
	                event.getVelocity(), event.getChannel()));
	        } else {
	            track.add(factory.createNoteOff(event.getStartEndTick(), event.getNote(),
	                event.getChannel()));
	        }
	    }
	    Sequencer sequencer = MidiSystem.getSequencer();
	    sequencer.open();
	    sequencer.setSequence(sequence);
	    sequencer.start();
	}

}
