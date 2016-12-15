package com.chf.example.jdk.net.tcp;

public class Main {

    public static void main(String[] args) throws Exception {
        int port = 10002;
        TcpServer tcpServer = new TcpServer(port);
        tcpServer.start();

        TcpClient tcpClient = new TcpClient(port);
        tcpClient.start();

        while (true) {
            try {
                tcpClient.sendMsg("client~~~");
                Thread.sleep(5000);
            } catch (Exception e) {
                break;
            }
        }

        System.out.println("end main");
    }

}
