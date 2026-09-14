
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String text = "Xin chao TCP Server!";
            out.println(text);
            System.out.println("[Client] Đã gửi: " + text);

            String response = in.readLine();
            System.out.println("[Client] Server phản hồi: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}