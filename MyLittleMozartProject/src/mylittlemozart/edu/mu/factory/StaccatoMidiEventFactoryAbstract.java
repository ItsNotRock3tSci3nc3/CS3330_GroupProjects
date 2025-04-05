package mylittlemozart.edu.mu.factory;

/**
 * Abstract factory for staccato MIDI events
 */
public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

    @Override
    public MidiEventFactory createFactory() {
        return new StaccatoMidiEventFactory();
    }
}
