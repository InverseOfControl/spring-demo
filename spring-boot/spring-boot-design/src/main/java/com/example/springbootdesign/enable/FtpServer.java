package com.example.springbootdesign.enable;

public class FtpServer implements Server {
    @Override
    public void start() {
        System.out.println("ftp.start");
    }

    @Override
    public void stop() {
        System.out.println("ftp.stop");
    }
}
