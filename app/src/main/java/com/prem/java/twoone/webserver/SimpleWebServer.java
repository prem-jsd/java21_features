package com.prem.java.twoone.webserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Path;

/**
 * todo:: Simple Web Server is a minimal HTTP server for serving a single directory hierarchy.
 * Goal is to provide a web server for computer science students for testing or prototyping purposes.
 */
public class SimpleWebServer {

    public static void main(String[] args) {

//        startFileServer();

        customFileServerHandler();
    }

    private static void startFileServer() {
        var server = SimpleFileServer.createFileServer(new InetSocketAddress(8080),
                Path.of("/Users/premkumar/Prem/pocs/java/java21/app/src/main/java/com/prem/java/twoone/webserver/html"),
                SimpleFileServer.OutputLevel.VERBOSE);
        server.start();
    }

    private static void customFileServerHandler() {
        try {
            var server = HttpServer.create(new InetSocketAddress(8081), 0);
            server.createContext("/custom", new MyHttpHandler());
            server.start();
        } catch (IOException ioe) {
            System.out.println("IOException occured");
        }
    }


}
