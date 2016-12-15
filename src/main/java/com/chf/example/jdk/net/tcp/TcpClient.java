package com.chf.example.jdk.net.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

    private int port;

    private Socket socket;

    public TcpClient(int port) {
        this.port = port;
    }

    public void start() {
        try {
            System.out.println("Connecting to server.");
            socket = new Socket("localhost", port);
            System.out.println("Connected to server.");
            new Thread(new ClientThread()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) throws IOException {
        try (OutputStream os = socket.getOutputStream(); DataOutputStream bos = new DataOutputStream(os);) {
            bos.writeUTF(msg);
            System.out.println("Client send : " + msg);
        } catch (IOException e) {
            throw e;
        }
    }

    public class ClientThread implements Runnable {

        public void run() {

            try (InputStream is = socket.getInputStream(); InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader buf = new BufferedReader(isr);) {

                while (true) {
                    String line = buf.readLine();
                    System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
