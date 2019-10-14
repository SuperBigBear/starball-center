package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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
        String url="http://starball-springboot-service-user-api/user/query";
        String result=restTemplate.getForObject(url,String.class);

        return  result;
    }
}
