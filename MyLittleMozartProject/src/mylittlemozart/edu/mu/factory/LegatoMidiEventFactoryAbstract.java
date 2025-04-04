package mylittlemozart.edu.mu.factory;

/**
 * Abstract factory for legato MIDI events
 */
public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {
    @Override
    public MidiEventFactory createFactory() {
        return new LegatoMidiEventFactory();
    }
}
