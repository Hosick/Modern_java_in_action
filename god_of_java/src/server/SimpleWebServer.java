package server;

import server.handler.RequestHandler;

import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer extends Thread {
    public static void main(String[] args) {
        SimpleWebServer simpleWebServer = new SimpleWebServer();
        int port = 9001;
        simpleWebServer.run(9001);
    }

    public void run(int port) {
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            while (true) {
                Socket socket = server.accept();
                //Require Read.
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}