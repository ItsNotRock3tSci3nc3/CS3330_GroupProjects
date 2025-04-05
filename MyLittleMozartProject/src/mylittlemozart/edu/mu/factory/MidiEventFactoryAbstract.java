package mylittlemozart.edu.mu.factory;

/**
 * Abstract factory interface for creating MIDI event factories
 */
public interface MidiEventFactoryAbstract {
    /**
     * Creates the concrete factory that implements MidiEventFactory.
     *
     * @return a MidiEventFactory
     */
    MidiEventFactory createFactory();
}
