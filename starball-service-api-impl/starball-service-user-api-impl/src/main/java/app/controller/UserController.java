package app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableEurekaClient
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/query")
    public String QueryInfo() {

        return "Hi Ming,This is from user service api! Port: " + serverPort;

    }

}
