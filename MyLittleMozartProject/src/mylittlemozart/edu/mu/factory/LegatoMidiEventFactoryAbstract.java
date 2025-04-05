package mylittlemozart.edu.mu.factory;

/**
 * Concrete abstract factory that returns a LegatoMidiEventFactory.
 */
public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

    @Override
    public MidiEventFactory createFactory() {
        return new LegatoMidiEventFactory();
    }
}
