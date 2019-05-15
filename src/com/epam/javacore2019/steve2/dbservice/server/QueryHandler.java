package com.epam.javacore2019.steve2.dbservice.server;

import com.epam.javacore2019.steve2.dbservice.misc.DataHandler;
import com.epam.javacore2019.steve2.dbservice.misc.Utils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.List;
import java.util.Map;

public class QueryHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange request) throws IOException {

        String response = "\nNEW REQUEST RECEIVED!";
        response += String.format("METHOD: %s", request.getRequestMethod());
        for (Map.Entry<String, List<String>> header : request.getRequestHeaders().entrySet()) {
            response += String.format("\n %s %s", header.getKey(), header.getValue());
        }
        InputStream is = request.getRequestBody();
        Utils.readStream(is, new DataHandler() {
            @Override
            public void handleString(String line) {
                String query = String.format("REQUEST BODY: %s", line);
                System.out.println(query);
            }
        });
        response += response + "\nI will be able to execute any query soon";
        request.sendResponseHeaders(200, response.length());
        OutputStream os = request.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
