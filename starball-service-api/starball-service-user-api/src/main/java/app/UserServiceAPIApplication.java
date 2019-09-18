package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class UserServiceAPIApplication {
    public  static  void  main(String[] args) {
        SpringApplication.run(UserServiceAPIApplication.class, args);
    }
}
