package mylittlemozart.edu.mu.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class AcousticGrandPianoStrategy implements InstrumentStrategy {

	 /**
     * Applies the Trumpet instrument to the specified MIDI track and channel.
     * It sends a PROGRAM_CHANGE message with the MIDI instrument number for Trumpet.
     *
     * @param track   the MIDI track to which the instrument change is applied
     * @param channel the MIDI channel where the instrument should be set
     * @throws InvalidMidiDataException if the MIDI data is invalid
     */
    @Override
    public void applyInstrument(Track track, int channel) {
        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
            MidiEvent event = new MidiEvent(message, 0);
            track.add(event);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
}
