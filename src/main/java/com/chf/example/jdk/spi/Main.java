package com.chf.example.jdk.spi;

import java.util.ServiceLoader;



public class Main {

    public static void main(String[] args) throws Exception {
        ServiceLoader<IService> services = ServiceLoader
                .load(IService.class);
        while (true) {
            for (IService service : services) {
                service.exec();
            }
            services.reload();
            Thread.sleep(10000);
        }
        // System.out.println("finish");
    }
}
