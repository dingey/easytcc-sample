package com.d.service;

import com.d.client.UserClient;
import com.d.mapper.GoodsMapper;
import com.github.dingey.easytcc.core.Compensable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@SuppressWarnings("unused")
@Service
public class GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private UserClient userClient;

    /**
     * reduce inventory
     *
     * @param id  id
     * @param num nums
     * @return 1success 0fail
     */
    @Compensable(confirm = "confirm", cancel = "cancel")
    @Transactional
    public Integer trying(Long id, Integer num) {
        Integer integer = goodsMapper.decreaseNum(id, num);
        integer += goodsMapper.increaseUsed(id, num);
        if (integer < 2) {
            throw new RuntimeException("库存不足");
        }
        //todo 测试循环调用
        userClient.increaseScore(1L, 1);
        log.debug("执行trying: id=" + id + " , num=" + num);
        return integer;
    }

    @Transactional
    public Integer confirm(Long id, Integer num) {

        log.debug("执行confirm: id=" + id + " , num=" + num);
        return 1;
    }

    @Transactional
    public Integer cancel(Long id, Integer num) {
        log.debug("执行cancel: id=" + id + " , num=" + num);
        Integer integer = goodsMapper.decreaseUsed(id, num);
        integer += goodsMapper.increaseNum(id, num);
        return integer;
    }
}
