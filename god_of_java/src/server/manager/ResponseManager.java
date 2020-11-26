package server.manager;

import server.dto.RequestDTO;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

public class ResponseManager {
    Socket socket;
    RequestDTO dto;

    public ResponseManager(Socket socket, RequestDTO dto) {
        this.socket = socket;
        this.dto = dto;
    }

    public void writeResponse() {
        try {
            PrintStream response = new PrintStream(socket.getOutputStream());
            response.println("HTTP/1.1 200 OK");
            response.println("Content-type: text/html");
            response.println();
            if (dto.getUri().equals("/today"))
                response.println(new Date());
            else if(dto.getUri().equals("/"))
                response.println("It is working!");
            else
                response.println("The requested page is not available.");
            response.println();
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}