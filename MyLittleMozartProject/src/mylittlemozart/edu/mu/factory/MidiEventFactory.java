package mylittlemozart.edu.mu.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

/**
 * Interface for creating MIDI events
 */
public interface MidiEventFactory {
    /**
     * Create a NOTE_ON MidiEvent at given tick.
     *
     * @param tick    the tick time
     * @param note    the MIDI note number
     * @param velocity MIDI velocity 
     * @param channel MIDI channel
     * @return a MidiEvent object
     * @throws InvalidMidiDataException if invalid data is passed in
     */
    MidiEvent createNoteOn(int tick, int note, int velocity, int channel)
        throws InvalidMidiDataException;

    /**
     * @param tick    the tick time
     * @param note    the MIDI note number
     * @param channel MIDI channel
     * @return a MidiEvent object
     * @throws InvalidMidiDataException if invalid data is passed in
     */
    MidiEvent createNoteOff(int tick, int note, int channel)
        throws InvalidMidiDataException;
}
