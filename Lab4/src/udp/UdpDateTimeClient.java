package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UdpDateTimeClient {
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 5001;

        try (DatagramSocket socket = new DatagramSocket();
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            
            InetAddress address = InetAddress.getByName(host);
            System.out.println("UDP Client đã sẵn sàng. Nhập DATE, TIME, DATETIME (hoặc QUIT để thoát):");
            
            String request;
            while ((request = console.readLine()) != null) {
                if (request.trim().equalsIgnoreCase("QUIT")) break;

                byte[] sendData = request.getBytes(StandardCharsets.UTF_8);
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
                socket.send(sendPacket);

                byte[] buffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);

                String response = new String(receivePacket.getData(), 0, receivePacket.getLength(), StandardCharsets.UTF_8);
                System.out.println("Server: " + response);
            }
        } catch (IOException e) {
            System.err.println("Lỗi kết nối UDP: " + e.getMessage());
        }
    }
}