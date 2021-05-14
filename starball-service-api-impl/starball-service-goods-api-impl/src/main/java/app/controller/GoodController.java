package app.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodController {
    @Value("${server.port}")
    private String serverPort;


    @RequestMapping("/getGoods")
    public String getGoodsList() {

        return "Goods list service , port :" + serverPort;
    }
}
