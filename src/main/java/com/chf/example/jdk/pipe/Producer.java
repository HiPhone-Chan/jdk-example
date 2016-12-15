package com.chf.example.jdk.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Producer extends Thread {

    private PipedInputStream pipedInputStream;

    public Producer() {
        this.pipedInputStream = new PipedInputStream();
    }

    @Override
    public void run() {
        try (PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);) {
            while (!isInterrupted()) {
                pipedOutputStream.write("Hello".getBytes());
                sleep(5000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (pipedInputStream != null) {
                try {
                    pipedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public PipedInputStream getPipedInputStream() {
        return pipedInputStream;
    }

}
