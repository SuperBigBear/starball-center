package com.cn.starball.gateway.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

//Config center
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class StarballConfigApp {
    public static void main(String[] args)
    {
        SpringApplication.run(StarballConfigApp.class,args);
    }
}
