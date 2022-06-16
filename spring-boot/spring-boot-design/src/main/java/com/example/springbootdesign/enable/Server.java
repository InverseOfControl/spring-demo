package com.example.springbootdesign.enable;

public interface Server {

    void start();

    void stop();

    enum Type {
        HTTP,
        FTP
    }

}
