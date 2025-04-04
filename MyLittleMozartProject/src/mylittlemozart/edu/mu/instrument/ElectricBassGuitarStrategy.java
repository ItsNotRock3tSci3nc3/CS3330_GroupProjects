package mylittlemozart.edu.mu.instrument;
import javax.sound.midi.*;
public class ElectricBassGuitarStrategy implements InstrumentStrategy{

	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		ShortMessage instrumentChange = new ShortMessage();
        instrumentChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0); // 33 = Electric Bass
        MidiEvent changeEvent = new MidiEvent(instrumentChange, 0);
        track.add(changeEvent);
		
	}
	
}
