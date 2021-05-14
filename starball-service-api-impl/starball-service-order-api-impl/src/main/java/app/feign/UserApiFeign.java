package app.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "starball-springboot-service-user-api-impl")
public interface UserApiFeign {

    //Feign call like SpringMVC  interface
    //@FeignClient call RPC  service interface, name parameter is service name

    @RequestMapping("/query")
    public String getUserInfo();
}
