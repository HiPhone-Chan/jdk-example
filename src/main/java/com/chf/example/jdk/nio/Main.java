package com.chf.example.jdk.nio;

public class Main {

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer(producer);
        producer.start();
        consumer.start();
    }

}
