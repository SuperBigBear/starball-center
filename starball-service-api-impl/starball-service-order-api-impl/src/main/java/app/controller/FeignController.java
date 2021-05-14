package app.controller;

import app.feign.UserApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {


    @Autowired
    private UserApiFeign userApiFeign;

    @RequestMapping("/feignUser")
    public String feignUserInfo()
    {
        return userApiFeign.getUserInfo();
    }
}
