package mylittlemozart.edu.mu.instrument;

import javax.sound.midi.*;


interface InstrumentStrategy {
	
	/**
	 * Applies the instrument change to the specified track and channel.
	 *
	 * @param track   the MIDI track to which the instrument change is applied
	 * @param channel the MIDI channel where the instrument should be set
	 * @throws InvalidMidiDataException if the MIDI data is invalid
	 */
	void applyInstrument(Track track, int channel) throws InvalidMidiDataException;
}
