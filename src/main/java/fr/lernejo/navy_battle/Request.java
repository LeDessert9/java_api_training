package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;
import java.net.http.HttpRequest;

public class Request {
    public final void postRequest(int port, String targetlink) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest postRequest = HttpRequest.newBuilder().uri(URI.create(targetlink + "/api/game/start"))
            .setHeader("Accept", "application/json").setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + port + "\", \"message\":\"message test\"}")).build();
        HttpResponse<String> res = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(res.body());
    }
}
