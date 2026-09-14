
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("[Server] Đang lắng nghe tại port " + port + "...");

            while (true) {

                Socket socket = serverSocket.accept();
                System.out.println("[Server] Client kết nối thành công: " + socket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message = in.readLine();
                System.out.println("[Server] Nhận được từ Client: " + message);

                out.println("Server phản hồi: " + message);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}