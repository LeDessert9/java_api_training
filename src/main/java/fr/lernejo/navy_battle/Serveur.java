package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Serveur {
    final HttpServer httpServer;
    Serveur(int port) throws IOException {
        this.httpServer = HttpServer.create(new InetSocketAddress(port), 0);
        this.httpServer.setExecutor(Executors.newSingleThreadExecutor());
        this.httpServer.createContext("/ping", new PingHandler());
        this.httpServer.createContext("/api/game/start", new Handler(port));
        this.httpServer.start();
    }
}
