package lab3.logging.destinations;

import lab3.logging.Logger;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RemoteLogger implements Logger {

    private final String url;

    public RemoteLogger(String url) {
        this.url = url;
    }

    public void log(String... msg) {
        String logStr = "";
        logStr += new SimpleDateFormat("hh:mm:ss").format(new Date());
        logStr += " -- ";
        logStr += String.join(" ", msg);
        logStr += "\n";

        HttpClient httpclient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .POST(HttpRequest.BodyPublishers.ofString(logStr))
                .build();
        try {
            httpclient.send(request, HttpResponse.BodyHandlers.discarding());
        } catch (Exception ignored) {
        }
    }

    public void logf(String fmt, String... values) {
        if (!fmt.endsWith("\n")) {
            fmt += "\n";
        }
        String date = new SimpleDateFormat("hh:mm:ss").format(new Date());
        fmt = date + " -- " + fmt;
        String logStr = fmt.formatted((Object[]) values);

        HttpClient httpclient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .POST(HttpRequest.BodyPublishers.ofString(logStr))
                .build();
        try {
            httpclient.send(request, HttpResponse.BodyHandlers.discarding());
        } catch (Exception ignored) {
        }
    }
}
