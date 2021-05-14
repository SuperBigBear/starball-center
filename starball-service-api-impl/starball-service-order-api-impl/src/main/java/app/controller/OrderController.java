package app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@EnableEurekaClient
@RequestMapping("/order")
public class OrderController {

    //RestTemplate component from springboot web with ribbon load balance by default
    //two ways to call remote api interface,rest and feign
    // (typical method is httpclient), rest and feign(feign is from spring cloud)

    @Autowired
    //@Resource(name="restTemplate")
    private RestTemplate restTemplate;

    private static Logger logger= LoggerFactory.getLogger(OrderController.class);

    //local balance ,get service list from register center
    @Autowired
    private DiscoveryClient discoveryClient;

    //Reset as 0 when clean up
    private  int requestCount=1;

    @RequestMapping("/query")
    public String QueryInfo()
    {
        return  "Hi Ming,This is from order service api";
    }


    @RequestMapping("/user/query")
    public  String QueryUserOrder()
    {
        //Two choice to invoke
        // one is to use application alias name to get url from registration center
        //Second is to call  service url from registration center
        String url="http://starball-springboot-service-user-api-impl/user/query";
        String result=restTemplate.getForObject(url,String.class);
        logger.info("Successfully received message from Eureka center: "+result);
        return  result;
    }
    @RequestMapping("/user/search")
    public  String QueryUserOrders()
    {
        String instanceUrl=getInstances();
        //Also use httpclient to call RPC
       String result= restTemplate.getForObject(instanceUrl,String.class);
        return  result;

    }

    //local balance，线程不安全，建议使用原子类，原子类CAS 是非阻塞算法的一种常见实现，相对于 synchronized 这种阻塞算法，它的性能更好。
    private  String getInstances()
    {
        String serviceName="starball-springboot-service-user-api";
        List<ServiceInstance> instances=discoveryClient.getInstances(serviceName);
        if (instances==null||instances.size()<=0)
        {return  null;}
        int instanceSize=instances.size();
        int serviceIndex=requestCount%instanceSize;
        requestCount++;
        return  instances.get(serviceIndex).getUri().toString();
    }
}
