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
	
	public int getStartEndTick() {
		return startEndTick;
	}
	
	public void setStartEndTick() {
		this.startEndTick = startEndTick;
	}
	
	public int getVelocity() {
		return velocity;
	}
	
	public void setVelocity() {
		this.velocity = velocity;
	}
	
	public int getNote() {
		return note;
	}
	
	public void setNote() {
		this.note = note;
	}
	
	public int getChannel() {
		return channel;
	}
	
	public void setChannel() {
		this.channel = channel;
	}
	
	public int getInstrument() {
		return instrument;
	}
	
	public void setInstrument() {
		this.instrument = instrument;
	}
	
	public int getNoteOnOff() {
		return noteOnOff;
	}
	
	public void setNoteOnOff() {
		this.noteOnOff = noteOnOff;
	}
}
