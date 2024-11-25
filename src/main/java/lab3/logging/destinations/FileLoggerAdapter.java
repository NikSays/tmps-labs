package lab3.logging.destinations;

import lab3.logging.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggerAdapter implements Logger {
    private final LegacyFileLogger logger;

    public FileLoggerAdapter(LegacyFileLogger logger) {
        this.logger = logger;
    }

    public void log(String... msg) {
        String logStr = "";
        logStr += new SimpleDateFormat("hh:mm:ss").format(new Date());
        logStr += " -- ";
        logStr += String.join(" ", msg);
        logStr += "\n";

        this.logger.logToFile(logStr);
    }

    public void logf(String fmt, String... values) {
        if (!fmt.endsWith("\n")) {
            fmt += "\n";
        }
        String date = new SimpleDateFormat("hh:mm:ss").format(new Date());
        fmt = date + " -- " + fmt;
        String logStr = fmt.formatted((Object[]) values);

        this.logger.logToFile(logStr);
    }
}
