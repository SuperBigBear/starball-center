package app.controller;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/query")
    public String QueryInfo()
    {
        return  "This is from order service api";
    }
}
