package mylittlemozart.edu.mu.data;

/**
 * Holds parsed MIDI event data from a CSV line.
 */
public class MidiEventData {
	private int startEndTick;
	private int velocity;
	private int note;
	private int channel;
	private int instrument;
	private int noteOnOff;
	
	/**
     * Constructor for MidiEventData.
     * 
     * @param startEndTick tick at which the note on/off occurs
     * @param velocity MIDI velocity
     * @param note MIDI note number
     * @param channel MIDI channel
     * @param instrument MIDI instrument number
     * @param noteOnOff either ShortMessage.NOTE_ON or ShortMessage.NOTE_OFF
     */
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
	
	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}
	
	public int getVelocity() {
		return velocity;
	}
	
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	public int getNote() {
		return note;
	}
	
	public void setNote(int note) {
		this.note = note;
	}
	
	public int getChannel() {
		return channel;
	}
	
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	public int getInstrument() {
		return instrument;
	}
	
	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}
	
	public int getNoteOnOff() {
		return noteOnOff;
	}
	
	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}
}
