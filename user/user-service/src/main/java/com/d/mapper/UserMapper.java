package com.d.mapper;

import com.d.model.User;
import com.github.dingey.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author d
 */
public interface UserMapper extends BaseMapper<User> {
    @Update("update user set score=score + #{score} where id=#{id}")
    Integer increaseScore(@Param("id") Long id, @Param("score") Integer score);
}
