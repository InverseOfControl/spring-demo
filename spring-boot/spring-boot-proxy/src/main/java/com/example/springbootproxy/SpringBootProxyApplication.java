package com.example.springbootproxy;

import com.example.springbootproxy.proxy.ProxyRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProxyApplication.class, args);
	}

	@Bean
	public ProxyRegister proxyRegister(){
		return new ProxyRegister("com.example.springbootproxy.test");
	}

}
