package com.chf.example.jdk.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    private int port;

    public TcpServer(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println("listening : " + port);
        new Thread(() -> {
            try (ServerSocket server = new ServerSocket(port);) {
                while (true) {
                    Socket client = server.accept();
                    System.out.println("get client : " + client);
                    new Thread(new ServerThread(client)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public class ServerThread implements Runnable {

        private Socket client;

        public ServerThread(Socket client) {
            this.client = client;
        }

        public void run() {
            try (InputStream is = client.getInputStream(); DataInputStream dis = new DataInputStream(is);) {
                while (true) {
                    System.out.println("Server get : " + dis.readUTF());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("end client : " + client);
        }

    }
}
