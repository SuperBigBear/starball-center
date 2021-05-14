package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient //向注册中心上注册服务
public class AppGoodsAPIApplication {


     
    public  static  void  main(String[] args) {

        SpringApplication.run(AppGoodsAPIApplication.class, args);
    }


}
