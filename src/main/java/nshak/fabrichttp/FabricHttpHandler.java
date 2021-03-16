package nshak.fabrichttp;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class FabricHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String requestParamValue = httpExchange.getRequestURI().toString();
        System.out.println(requestParamValue);
        String htmlResponse = "{}";
        httpExchange.sendResponseHeaders(200, htmlResponse.length());
    }
}
