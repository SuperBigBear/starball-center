package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient
public class OrderServiceAPIApplication {
    public  static  void  main(String[] args) {
        SpringApplication.run(OrderServiceAPIApplication.class, args);
    }
}
