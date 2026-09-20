package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TcpDateTimeServer {
    private static final int PORT = 5000;
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd MM yyyy");
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH mm ss");
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern("dd MM yyyy HH mm ss");

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("TCP DateTime Server đang lắng nghe trên cổng " + PORT);
            while (true) {
                try (Socket socket = server.accept()) {
                    serve(socket);
                } catch (IOException e) {
                    System.err.println("Lỗi phiên client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Không mở được server: " + e.getMessage());
        }
    }

    static void serve(Socket socket) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)) {
            
            String request;
            while ((request = in.readLine()) != null) {
                String trimmed = request.trim();
                LocalDateTime now = LocalDateTime.now();
                
                if (trimmed.equalsIgnoreCase("DATE")) {
                    out.println("OK " + now.format(DATE_FMT));
                } else if (trimmed.equalsIgnoreCase("TIME")) {
                    out.println("OK " + now.format(TIME_FMT));
                } else if (trimmed.equalsIgnoreCase("DATETIME")) {
                    out.println("OK " + now.format(DATETIME_FMT));
                } else if (trimmed.equalsIgnoreCase("QUIT")) {
                    out.println("OK BYE");
                    break;
                } else {
                    out.println("ERR UNKNOWN_COMMAND");
                }
            }
        }
    }
}