package app;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    private static Logger log = LoggerFactory.getLogger(EurekaApplication.class);
    public  static  void  main(String[] args)
    {
        //SpringApplication.run(EurekaApplication.class,args);
        //EurekaClientConfigBean
        SpringApplication.run(EurekaApplication.class, args);
        log.info("Eureka Server is running...");
        //new SpringApplicationBuilder(EurekaApplication.class).web(WebApplicationType.NONE).run(args);
    }
}
