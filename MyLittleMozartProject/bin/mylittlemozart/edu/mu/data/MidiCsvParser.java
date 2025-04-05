package mylittlemozart.edu.mu.data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.ShortMessage;

/**
 * Parses a CSV file and returns a list of MidiEventData.
 */
public class MidiCsvParser {

    /**
     * Parses a CSV file with expected format
     * 
     * @param filePath path to the CSV file
     * @return a list of MidiEventData
     * @throws IOException if there's an error reading the file
     */
    public static List<MidiEventData> parseCsv(String filePath) throws IOException {
        List<MidiEventData> events = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) { // skip any empty lines
                    continue;
                }

                String[] values = line.split(",");

                if (values.length < 6) { // chech for 6 columns
                    continue;
                }

                for (int i = 0; i < values.length; i++) { // avoid whitespace errors
                    values[i] = values[i].trim();
                }

                int startEndTick = Integer.parseInt(values[0]);
                String noteOnOffStr = values[1];
                int channel = Integer.parseInt(values[2]);
                int note = Integer.parseInt(values[3]);
                int velocity = Integer.parseInt(values[4]);
                int instrument = Integer.parseInt(values[5]);

                int noteOnOff;
                if (noteOnOffStr.equalsIgnoreCase("Note_on_c")) { // covert string to be on or off
                    noteOnOff = ShortMessage.NOTE_ON;
                } else {
                    noteOnOff = ShortMessage.NOTE_OFF;
                }

                MidiEventData data = new MidiEventData( // create MidiEventData object
                        startEndTick,
                        velocity,
                        note,
                        channel,
                        instrument,
                        noteOnOff
                );

                events.add(data);
            }
        }

        return events;
    }
}
