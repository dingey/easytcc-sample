package com.d.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author d
 */
@FeignClient(name = "USER-SERVICE")
public interface UserClient {
    /**
     * increase user score
     *
     * @param id id
     * @return 1success 0fail
     */
    @GetMapping(path = "/score/increase")
    Integer increaseScore(@RequestParam(name = "id") Long id, @RequestParam(name = "score") Integer score);
}
