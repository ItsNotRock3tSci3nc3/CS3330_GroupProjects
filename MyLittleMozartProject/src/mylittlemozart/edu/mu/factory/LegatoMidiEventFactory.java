package mylittlemozart.edu.mu.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Legato MIDI event factory that extends note durations
 */
public class LegatoMidiEventFactory implements MidiEventFactory {

    private static final int LEGATO_EXTENSION = 80;

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
        return new MidiEvent(message, tick + LEGATO_EXTENSION);
    }
}
