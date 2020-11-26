package server.handler;

import server.dto.RequestDTO;
import server.manager.RequestManager;
import server.manager.ResponseManager;

import java.net.Socket;

public class RequestHandler extends Thread {
    Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        RequestManager requestManager = new RequestManager(socket);
        RequestDTO dto = requestManager.readRequest();
        ResponseManager responseManager = new ResponseManager(socket, dto);
        responseManager.writeResponse();
    }
}
