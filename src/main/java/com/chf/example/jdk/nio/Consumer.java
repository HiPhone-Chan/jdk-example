package com.chf.example.jdk.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe.SourceChannel;

public class Consumer extends Thread {

    private SourceChannel sourceChannel;

    private ByteBuffer buffer;

    public Consumer(Producer producer) {
        this.sourceChannel = producer.getSourceChannel();
        buffer = ByteBuffer.allocate(1024);

    }

    @Override
    public void run() {

        while (!isInterrupted()) {
            try {
                int length = sourceChannel.read(buffer);
                if (length > 0) {
                    System.out.println(new String(buffer.array()));
                    buffer.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
