package com.d.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author d
 */
@FeignClient(name = "GOODS-SERVICE")
public interface GoodsClient {
    /**
     * reduce inventory
     *
     * @param id  id
     * @param num nums
     * @return 1success 0fail
     */
    @GetMapping(path = "/goods/reduce")
    Integer reduce(@RequestParam(name = "id") Long id, @RequestParam(name = "num") Integer num);
}
