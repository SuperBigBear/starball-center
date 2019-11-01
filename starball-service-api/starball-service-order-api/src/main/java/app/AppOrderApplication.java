package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
public class AppOrderApplication {


     
    public  static  void  main(String[] args) {

        SpringApplication.run(AppOrderApplication.class, args);
        //If use RestTemplate to call service ,depends on Ribbon load balance
        //Add @LoadBalanced annotation on restTemplate function,Enable RestTemplate load balance
    }


    //Fix RestTemplate not found， Register RestTemplate  into SpringBoot container @Bean
    //If use DiscoveryClient to loadbalance service ,please comment @LoadBalanced
    @Bean
    @LoadBalanced
    RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
