package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpDigitServer {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("TCP Digit Server đang lắng nghe trên cổng " + PORT);

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
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(
                     socket.getOutputStream(), StandardCharsets.UTF_8), true)) {
            
            String request;
            while ((request = in.readLine()) != null) {
                String trimmed = request.trim();
                if (trimmed.equalsIgnoreCase("QUIT")) {
                    out.println("OK BYE");
                    break;
                }
                String response = process(request);
                out.println(response);
            }
        }
    }

    static String process(String request) {
        // Xử lý ca biên: chuỗi rỗng hoặc null
        if (request == null || request.isEmpty()) {
            return "ERR INVALID_DIGIT";
        }

        // Kiểm tra xem chuỗi có đúng 1 ký tự và có phải là chữ số từ '0' đến '9' hay không.
        // Điều này giúp tự động loại bỏ các ca biên như: "10", "a", có khoảng trắng (" 5 ", "9 "), ...
        if (request.length() !=  1) {
            return "ERR INVALID_DIGIT";
        }

        char c = request.charAt(0);
        if (c < '0' || c > '9') {
            return "ERR INVALID_DIGIT";
        }

        // Đổi chữ số sang cách đọc tiếng Việt
        switch (c) {
            case '0': return "OK Không";
            case '1': return "OK Một";
            case '2': return "OK Hai";
            case '3': return "OK Ba";
            case '4': return "OK Bốn";
            case '5': return "OK Năm";
            case '6': return "OK Sáu";
            case '7': return "OK Bảy";
            case '8': return "OK Tám";
            case '9': return "OK Chín";
            default: return "ERR INVALID_DIGIT";
        }
    }
}