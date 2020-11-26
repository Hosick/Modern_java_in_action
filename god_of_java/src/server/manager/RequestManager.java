package server.manager;

import server.dto.RequestDTO;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class RequestManager {
    Socket socket;

    public RequestManager(Socket socket) {
        this.socket = socket;
    }

    private final int BUFFER_SIZE = 2048;

    public RequestDTO readRequest() {
        RequestDTO dto = null;
        try {
            InputStream request = new BufferedInputStream(socket.getInputStream());
            byte[] receivedBytes = new byte[BUFFER_SIZE];
            request.read(receivedBytes);
            String requestData = new String(receivedBytes).trim();
            StringTokenizer st = new StringTokenizer(requestData);
            dto = new RequestDTO(st.nextToken(), st.nextToken(), st.nextToken());
            System.out.println("RequestData=\n" + requestData);
            System.out.println("-------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }
}