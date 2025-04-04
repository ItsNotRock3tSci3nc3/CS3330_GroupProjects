package mylittlemozart.edu.mu.instrument;

import javax.sound.midi.*;

interface InstrumentStrategy {
	void applyInstrument(Track track, int channel) throws InvalidMidiDataException;
}
