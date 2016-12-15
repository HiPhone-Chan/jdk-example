package com.chf.example.jdk.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

public class Consumer extends Thread {

    private PipedInputStream pipedInputStream;

    private byte[] buffer;

    public Consumer(Producer producer) {
        this.pipedInputStream = producer.getPipedInputStream();
        buffer = new byte[1024];
    }

    @Override
    public void run() {

        while (!isInterrupted()) {
            try {
                int length = pipedInputStream.read(buffer);
                if (length > 0) {
                    System.out.println(new String(buffer, 0, length));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
