package network;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

public class HostUriInspector {
    public static void main(String[] args) {
    
        if (args.length < 2) {
            System.out.println("Usage: java network.HostUriInspector <hostname> <uri>");
            return;
        }

        String hostname = args[0];
        String uriStr = args[1];

        System.out.println("=== 1. KHAO SAT HOSTNAME: " + hostname + " ===");
        try {
            InetAddress[] addresses = InetAddress.getAllByName(hostname);
            for (InetAddress address : addresses) {
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
            System.err.println("[LOI] Khong phan giai duoc hostname: " + hostname);
        }

        System.out.println("\n=== 2. KHAO SAT URI: " + uriStr + " ===");
        try {
            URI uri = new URI(uriStr);
            System.out.println("- Scheme: " + uri.getScheme());
            System.out.println("- Host: " + uri.getHost());
            System.out.println("- Port: " + uri.getPort());
            System.out.println("- Path: " + uri.getPath());
            System.out.println("- Query: " + uri.getQuery());
            System.out.println("- Fragment: " + uri.getFragment());
        } catch (URISyntaxException e) {
            System.err.println("[LOI] URI khong hop le: " + e.getMessage());
        }
    }
}