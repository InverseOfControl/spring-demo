package com.example.springbootdesign.enable;

public class HttpServer implements Server {
    @Override
    public void start() {
        System.out.println("http.start");
    }

    @Override
    public void stop() {
        System.out.printf("http.stop");
    }
}
