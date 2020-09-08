package com.d.mapper;

import com.d.model.Order;
import com.github.dingey.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author d
 */
public interface OrderMapper extends BaseMapper<Order> {
    @Update("update `order` set `status` = #{status} where order_no = #{orderNo} and `status`=0")
    int updateOrderStatus(@Param("orderNo") String orderNo, @Param("status") Integer status);
}
