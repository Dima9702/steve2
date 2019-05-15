package com.epam.javacore2019.steve2.webservice;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public enum WebClientApplication {
    INSTANCE;

    public static final int PORT = 6703;
    public static final String APP_NAME = "Web Client Service";


    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10);
        server.createContext("/pages/", new HtmlHandler());
        server.createContext("/css/", new CssHandler());
        server.createContext("/js/", new JsHandler());
        server.createContext("/api/testget", new ApiGetTestHandler());
        server.createContext("/api/testpost", new ApiPostHandler());

        server.start();
        String message = String.format("%s is running on port: %d", APP_NAME, server.getAddress().getPort() );
        System.out.println(message);
    }
}
