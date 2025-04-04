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
     * Parses a CSV file with expected format:
     *   startEndTick, Note_on_c or Note_off_c, channel, note, velocity, instrument
     * Example line:
     *   0, Note_on_c, 0, 43, 100, 34
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
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Split the line by commas
                String[] values = line.split(",");

                // OPTIONAL: If your CSV has a header row you want to ignore, e.g.:
                // if (values[0].equalsIgnoreCase("startEndTick")) {
                //     continue; // skip header
                // }

                // Check we have at least 6 columns
                if (values.length < 6) {
                    // If not enough columns, skip or throw an exception
                    // For now, let's just skip it
                    continue;
                }

                // Trim whitespace to avoid parsing errors
                for (int i = 0; i < values.length; i++) {
                    values[i] = values[i].trim();
                }

                int startEndTick = Integer.parseInt(values[0]);
                String noteOnOffStr = values[1];
                int channel = Integer.parseInt(values[2]);
                int note = Integer.parseInt(values[3]);
                int velocity = Integer.parseInt(values[4]);
                int instrument = Integer.parseInt(values[5]);

                // Convert the string to ShortMessage.NOTE_ON or ShortMessage.NOTE_OFF
                int noteOnOff;
                if (noteOnOffStr.equalsIgnoreCase("Note_on_c")) {
                    noteOnOff = ShortMessage.NOTE_ON;
                } else {
                    // Assume everything else is Note_off_c
                    noteOnOff = ShortMessage.NOTE_OFF;
                }

                // Create the MidiEventData object
                MidiEventData data = new MidiEventData(
                        startEndTick,
                        velocity,
                        note,
                        channel,
                        instrument,
                        noteOnOff
                );

                // Add to the list
                events.add(data);
            }
        }

        return events;
    }
}
