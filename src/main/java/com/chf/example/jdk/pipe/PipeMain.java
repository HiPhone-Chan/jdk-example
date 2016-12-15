package com.chf.example.jdk.pipe;

public class PipeMain {

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer(producer);
        producer.start();
        consumer.start();
    }

}
