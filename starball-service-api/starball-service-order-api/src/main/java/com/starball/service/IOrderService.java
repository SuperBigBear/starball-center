package com.starball.service;

import com.starball.entity.OrderInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IOrderService {

    @RequestMapping("/getOrder")
     OrderInfo getOrderInfo(@RequestParam("id") String id);
}
