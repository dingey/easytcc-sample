package com.d.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * @author d
 */
@Data
public class OrderDTO {
    private Long uid;
    private String orderNo;
    private String title;
    private List<OrderItemDTO> item;

    public OrderDTO generateOrderNo() {
        this.setOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
        return this;
    }
}
