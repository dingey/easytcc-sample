package com.d.mapper;

import com.d.model.Goods;
import com.github.dingey.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author d
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Update("update goods set used = used + #{num} where id = #{id} and num + used + #{num}=total")
    Integer increaseUsed(@Param("id") Long id, @Param("num") Integer num);

    @Update("update goods set used = used - #{num} where id = #{id} and used >= #{num}")
    Integer decreaseUsed(@Param("id") Long id, @Param("num") Integer num);

    @Update("update goods set num = num + #{num} where id = #{id}")
    Integer increaseNum(@Param("id") Long id, @Param("num") Integer num);

    @Update("update goods set num = num - #{num} where id = #{id} and num >= #{num}")
    Integer decreaseNum(@Param("id") Long id, @Param("num") Integer num);
}
