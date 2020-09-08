package com.d.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author d
 */
@Data
@Table(name = "`order`")
public class Order {
    @Id
    private Long id;
    private String title;
    private String orderNo;
    /**
     * 0待校验 1创建成功 2创建失败
     */
    private Integer status;
}
