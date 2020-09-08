package com.d.service;

import com.d.mapper.UserMapper;
import com.github.dingey.easytcc.core.Compensable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Compensable(confirm = "confirm", cancel = "cancel")
    @Transactional
    public Integer increaseScore(Long id, Integer score) {
        Integer integer = userMapper.increaseScore(id, score);
        if (integer < 1) {
            throw new RuntimeException("加积分失败");
        }
        log.debug("执行trying: id=" + id + " , num=" + score);
        return integer;
    }

    @Transactional
    public Integer confirm(Long id, Integer score) {

        log.debug("执行confirm: id=" + id + " , score=" + score);
        return 1;
    }

    @Transactional
    public Integer cancel(Long id, Integer score) {
        log.debug("执行cancel: id=" + id + " , score=" + score);
        Integer integer = userMapper.increaseScore(id, -score);
        return integer;
    }
}
