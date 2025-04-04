package mylittlemozart.edu.mu.pitch;

public class LowerPitchStrategy implements PitchStrategy{
	private static final int PITCH_DECREASE = 2;

    /**
     * Decreases pitch by 2 semitones.
     *
     * @param note the original note value
     * @return the note value decreased by 2
     */
    @Override
    public int modifyPitch(int note) {
        return note - PITCH_DECREASE;
    }
}
