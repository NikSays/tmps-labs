package lab2.logging;

import lab2.logging.destinations.FileLoggerAdapter;
import lab2.logging.destinations.LegacyFileLogger;
import lab2.logging.destinations.RemoteLogger;
import lab2.logging.destinations.StdOutLogger;

import java.io.FileWriter;
import java.io.IOException;

public class LoggingFacade implements Logger {
    private final Logger file;
    private final Logger stdio;
    private final Logger remote;

    public LoggingFacade(String file, String url) throws IOException {
        this.file = new FileLoggerAdapter(new LegacyFileLogger(new FileWriter(file, true)));
        this.stdio = new StdOutLogger();
        this.remote = new RemoteLogger(url);
    }

    public void log(String... msg) {
        this.file.log(msg);
        this.stdio.log(msg);
        this.remote.log(msg);
    }

    public void logf(String fmt, String... values) {
        this.file.logf(fmt, values);
        this.stdio.logf(fmt, values);
        this.remote.logf(fmt, values);
    }
}
