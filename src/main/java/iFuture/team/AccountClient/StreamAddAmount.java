package iFuture.team.AccountClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StreamAddAmount extends Thread {
    int id;
    long value;
    Logger log = LogManager.getLogger();

    public StreamAddAmount(int id, long value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public void run() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(String.format("http://localhost:7001/addValue?id=%s&value=%s", id, value)))
                    .GET()
                    .build();
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            log.info("bad request");
        }
    }
}
