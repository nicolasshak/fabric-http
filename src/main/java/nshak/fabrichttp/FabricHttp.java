package nshak.fabrichttp;

import com.sun.net.httpserver.HttpServer;
import net.fabricmc.api.ModInitializer;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FabricHttp implements ModInitializer {

    private HttpServer server;

    @Override
    public void onInitialize() {
        try {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

            server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
            server.createContext("/", new FabricHttpHandler());
            server.setExecutor(threadPoolExecutor);
            server.start();
            System.out.println("Server started on port 8080");
        } catch(Exception e) {

        }
    }
}
