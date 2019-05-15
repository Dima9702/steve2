package com.epam.javacore2019.steve2.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class CssHandler implements HttpHandler {

    public static final String CSS_FORMAT = "^/css/(([a-zA-Z]+\\.)(css))$";

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String path = httpExchange.getRequestURI().getPath();
        String response = "";
        if (path.matches(CSS_FORMAT)) {
            response = path;
        } else {
            response = "INVALID URL : " + path;
        }
        File file = new File("webclient/static" + path);
        response += "File Exists: " + file.exists();
        byte[] fileBytes = null;

        if(file.exists()){
            fileBytes = Utils.readBytes("webclient/static" + path);
        }

        httpExchange.getResponseHeaders().set("Content-Type", "text/css");
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody();
        //os.write(response.getBytes());
        if (fileBytes != null) {
            os.write(fileBytes);
        }
        os.close();

    }
}
