package lab3.logging.destinations;

import java.io.FileWriter;
import java.io.IOException;

public class LegacyFileLogger {

    private final FileWriter file;

    public LegacyFileLogger(FileWriter file) {
        this.file = file;
    }

    void logToFile(String msg) {
        try {
            this.file.write(msg);
            this.file.flush();
        } catch (IOException ignored) {
        }
    }
}
