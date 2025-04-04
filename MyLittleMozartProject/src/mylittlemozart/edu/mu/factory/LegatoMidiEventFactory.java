package mylittlemozart.edu.mu.factory;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.InvalidMidiDataException;

/**
 * Legato MIDI event factory that extends note durations
 */
public class LegatoMidiEventFactory implements MidiEventFactory{
	private static final int DURATION_EXTENSION = 80;
	
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel)
		throws InvalidMiniDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(message, tick);
	}
	
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel)
		throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		int adjustedTick = Math.max(0, tick + DURATION_REDUCTION);
		return new MidiEvent(message, adjustedTick);
	}
}
