package com.chf.example.jdk.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;

public class Producer extends Thread {

    private SinkChannel sinkChannel;

    private Pipe pipe;

    public Producer() {
        try {
            pipe = Pipe.open();
            this.sinkChannel = pipe.sink();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            while (!isInterrupted()) {
                sinkChannel.write(ByteBuffer.wrap("Hello".getBytes()));
                sleep(5000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (sinkChannel != null) {
                try {
                    sinkChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public SourceChannel getSourceChannel() {
        return pipe.source();
    }

}
