package mylittlemozart.edu.mu.pitch;

public class HigherPitchStrategy implements PitchStrategy{
	private static final int PITCH_INCREASE = 2;

    /**
     * Increases pitch by 2 semitones.
     *
     * @param note the original note value
     * @return the note value increased by 2
     */
    @Override
    public int modifyPitch(int note) {
        return note + PITCH_INCREASE;
    }
}
