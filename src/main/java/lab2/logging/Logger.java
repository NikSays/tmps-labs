package lab2.logging;

public interface Logger {
    void log(String... msg);

    void logf(String fmt, String... values);
}