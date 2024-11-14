package lab2.logging.destinations;

import lab2.logging.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StdOutLogger implements Logger {

    public void log(String... msg) {
        String logStr = "";
        logStr += new SimpleDateFormat("hh:mm:ss").format(new Date());
        logStr += " -- ";
        logStr += String.join(" ", msg);
        System.out.println(logStr);
    }

    public void logf(String fmt, String... values) {
        if (!fmt.endsWith("\n")) {
            fmt += "\n";
        }
        String date = new SimpleDateFormat("hh:mm:ss").format(new Date());
        System.out.print(date + " -- ");
        System.out.printf(fmt, (Object[]) values);
    }
}
