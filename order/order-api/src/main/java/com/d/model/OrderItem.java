package com.d.model;

import lombok.Data;

import javax.persistence.Id;

/**
 * @author d
 */
@Data
public class OrderItem {
	@Id
	private Long id;
	private Long orderId;
	private Long goodsId;
	private Integer num;
}
