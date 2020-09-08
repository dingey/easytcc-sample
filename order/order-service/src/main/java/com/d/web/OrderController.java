package com.d.web;

import com.d.dto.OrderDTO;
import com.d.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author d
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @ApiOperation("创建订单")
    @PostMapping(path = "/order")
    public Integer insert(@RequestBody OrderDTO orderDTO) {
        return orderService.insert(orderDTO.generateOrderNo());
    }

    @ApiOperation("获取订单号")
    @GetMapping(path = "/no")
    public Object insert() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
