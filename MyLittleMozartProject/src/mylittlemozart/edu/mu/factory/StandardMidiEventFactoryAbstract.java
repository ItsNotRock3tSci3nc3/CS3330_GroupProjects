package mylittlemozart.edu.mu.factory;

/**
 * Abstract factory for standard MIDI events
 */
public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

    @Override
    public MidiEventFactory createFactory() {
        return new StandardMidiEventFactory();
    }
}
