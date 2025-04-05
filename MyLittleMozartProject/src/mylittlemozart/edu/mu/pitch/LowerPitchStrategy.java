package mylittlemozart.edu.mu.pitch;

public class LowerPitchStrategy implements PitchStrategy {

	/**
     * Decreases pitch by 2 semitones.
     *
     * @param note the original note value
     * @return the note value decreased by 2
     */
    @Override
    public int modifyPitch(int note) {
        int newNote = note - 2;
        if (newNote < 0) {
            newNote = 0;
        }
        return newNote;
    }
}
