package com.d.model;

import lombok.Data;

import javax.persistence.Id;

/**
 * @author d
 */
@Data
public class Goods {
    @Id
    private Long id;
    private String name;
    /**
     * 可用数量
     */
    private Integer num;
    /**
     * 已用数量
     */
    private Integer used;
    /**
     * 初始总量
     */
    private Integer total;
}
