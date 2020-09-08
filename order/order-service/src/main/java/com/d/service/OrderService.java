package com.d.service;

import com.d.client.GoodsClient;
import com.d.client.UserClient;
import com.d.dto.OrderDTO;
import com.d.dto.OrderItemDTO;
import com.d.mapper.OrderItemMapper;
import com.d.mapper.OrderMapper;
import com.d.model.Order;
import com.d.model.OrderItem;
import com.github.dingey.easytcc.core.Compensable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderItemMapper ordrItemMapper;
    @Resource
    private GoodsClient goodsClient;
    @Resource
    private UserClient userClient;


    @Compensable(confirm = "confirm")
    @Transactional
    public Integer insert(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderNo(orderDTO.getOrderNo());
        order.setTitle(orderDTO.getTitle());
        order.setStatus(0);
        int insert = orderMapper.insertSelective(order);
        for (OrderItemDTO it : orderDTO.getItem()) {
            Integer reduce = goodsClient.reduce(it.getGoodsId(), it.getNum());
            if (reduce > 0) {
                OrderItem oi = new OrderItem();
                oi.setGoodsId(it.getGoodsId());
                oi.setNum(it.getNum());
                oi.setOrderId(order.getId());
                ordrItemMapper.insertSelective(oi);
            } else {
                throw new RuntimeException("库存不足");
            }
        }
//        userClient.increaseScore(orderDTO.getUid(), 1);
        return insert;
    }

    @Transactional
    public Integer confirm(OrderDTO orderDTO) {
        return orderMapper.updateOrderStatus(orderDTO.getOrderNo(), 2);
    }
}
