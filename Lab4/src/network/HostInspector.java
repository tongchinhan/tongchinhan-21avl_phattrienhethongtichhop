package network;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostInspector {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java network.HostInspector <hostname>");
            return;
        }

        try {
            InetAddress[] addresses = InetAddress.getAllByName(args[0]);
            System.out.println("Host: " + args[0]);

            for (InetAddress address : addresses) {
                // Xác định loại IP là IPv4 hay IPv6 dựa trên kiểu thực tế
                String ipType = "Unknown";
                if (address instanceof Inet4Address) {
                    ipType = "IPv4";
                } else if (address instanceof Inet6Address) {
                    ipType = "IPv6";
                }

                System.out.println("- IP: " + address.getHostAddress() + " (" + ipType + ")");
                System.out.println("  Canonical: " + address.getCanonicalHostName());
                System.out.println("  Loopback: " + address.isLoopbackAddress());
                System.out.println("  Site local: " + address.isSiteLocalAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("Không phân giải được host: " + args[0]);
        }
    }
}