package mylittlemozart.edu.mu.instrument;

import javax.sound.midi.*;


public class AcousticGrandPianoStrategy implements InstrumentStrategy {

	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		ShortMessage instrumentChange = new ShortMessage();
        instrumentChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
        MidiEvent changeEvent = new MidiEvent(instrumentChange, 0);
        track.add(changeEvent);
	}
	

}
