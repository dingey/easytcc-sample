package com.d.web;

import com.d.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author d
 */
@RestController
public class GoodsController {
    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @ApiOperation("减库存")
    @GetMapping(path = "/goods/reduce")
    public Integer trying(Long id, Integer num) {
        try {
            return goodsService.trying(id, num);
        } catch (Exception e) {
            return 0;
        }
    }
}
