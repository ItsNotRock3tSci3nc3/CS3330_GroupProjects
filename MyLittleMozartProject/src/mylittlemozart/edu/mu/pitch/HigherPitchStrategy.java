package mylittlemozart.edu.mu.pitch;

public class HigherPitchStrategy implements PitchStrategy {

	/**
     * Increases pitch by 2 semitones.
     *
     * @param note the original note value
     * @return the note value increased by 2
     */
    @Override
    public int modifyPitch(int note) {
        int newNote = note + 2;
        if (newNote > 127) {
            newNote = 127;
        }
        return newNote;
    }
}
