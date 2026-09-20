package udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UdpDateTimeServer {
    private static final int PORT = 5001;
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd MM yyyy");
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH mm ss");
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern("dd MM yyyy HH mm ss");

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("UDP DateTime Server đang lắng nghe trên cổng " + PORT);
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String request = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8).trim();
                LocalDateTime now = LocalDateTime.now();
                String responseStr;

                if (request.equalsIgnoreCase("DATE")) {
                    responseStr = "OK " + now.format(DATE_FMT);
                } else if (request.equalsIgnoreCase("TIME")) {
                    responseStr = "OK " + now.format(TIME_FMT);
                } else if (request.equalsIgnoreCase("DATETIME")) {
                    responseStr = "OK " + now.format(DATETIME_FMT);
                } else {
                    responseStr = "ERR UNKNOWN_COMMAND";
                }

                byte[] resData = responseStr.getBytes(StandardCharsets.UTF_8);
                DatagramPacket resPacket = new DatagramPacket(resData, resData.length, packet.getAddress(), packet.getPort());
                socket.send(resPacket);
            }
        } catch (IOException e) {
            System.err.println("Lỗi UDP Server: " + e.getMessage());
        }
    }
}