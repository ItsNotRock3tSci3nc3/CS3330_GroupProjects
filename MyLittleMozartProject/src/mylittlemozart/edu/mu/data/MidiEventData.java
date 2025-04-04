package mylittlemozart.edu.mu.data;

public class MidiEventData {
	private int startEndTick;
	private int velocity;
	private int note;
	private int channel;
	private int instrument;
	private int noteOnOff;
	
	public MidiEventData(int startEndTick, int velocity, int note, int channel, int instrument, int noteOnOff) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.instrument = instrument;
		this.noteOnOff = noteOnOff;
	}
	
	
}
