package mylittlemozart.edu.mu.instrument;
import javax.sound.midi.*;
public class ElectricBassGuitarStrategy implements InstrumentStrategy{

	/**
     * Applies the Electric Bass Guitar instrument to the specified MIDI track and channel.
     * It sends a PROGRAM_CHANGE message with the MIDI instrument number for Electric Bass Guitar.
     *
     * @param track   the MIDI track to which the instrument change is applied
     * @param channel the MIDI channel where the instrument should be set
     * @throws InvalidMidiDataException if the MIDI data is invalid
     */
	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		ShortMessage instrumentChange = new ShortMessage();
        instrumentChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0); // 33 = Electric Bass
        MidiEvent changeEvent = new MidiEvent(instrumentChange, 0);
        track.add(changeEvent);
		
	}
	
}
