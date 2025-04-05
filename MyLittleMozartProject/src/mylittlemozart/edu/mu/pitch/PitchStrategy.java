package mylittlemozart.edu.mu.pitch;

public interface PitchStrategy {
    /**
     * Modifies the given note's pitch.
     *
     * @param note the original note value
     * @return the modified note value
     */
    int modifyPitch(int note);
}
