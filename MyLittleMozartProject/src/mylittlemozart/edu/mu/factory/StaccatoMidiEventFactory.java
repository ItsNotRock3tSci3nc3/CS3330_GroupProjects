package mylittlemozart.edu.mu.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Factory for staccato MIDI events
 */
public class StaccatoMidiEventFactory implements MidiEventFactory {

    private static final int STACCATO_REDUCTION = 120;

    @Override
    public MidiEvent createNoteOn(int tick, int note, int velocity, int channel)
            throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
        return new MidiEvent(message, tick);
    }

    @Override
    public MidiEvent createNoteOff(int tick, int note, int channel)
            throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);

        int adjustedTick = tick - STACCATO_REDUCTION;
        if (adjustedTick < 0) {
            adjustedTick = 0;
        }
        return new MidiEvent(message, adjustedTick);
    }
}
