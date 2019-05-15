package com.epam.javacore2019.steve2.appserver;

import com.epam.javacore2019.steve2.webservice.WebClientApplication;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CriminalsApiHandler implements HttpHandler {

    public static final String LIST_REQUEST = "^/api/criminals/$"; //"/criminals"
    public static final String PERSON_REQUEST = "^/api/criminals/([0-9]+)$"; //"/criminals/{n}"

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String path = httpExchange.getRequestURI().getPath();
        httpExchange.getResponseHeaders().put("Content-Type", Arrays.asList(new String[]{"text/plain"}));
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody();
        String response = "";

        if (path.matches(LIST_REQUEST)) {
            response = "LIST";
            os.write(response.getBytes());
            //httpExchange.sendResponseHeaders(200, 0);
        } else if (path.matches(PERSON_REQUEST)){
            response = "PERSON";
            os.write(response.getBytes());
            //httpExchange.sendResponseHeaders(200, 0);
        } else {
            httpExchange.sendResponseHeaders(400, 0);
        }
        os.close();
    }
}
