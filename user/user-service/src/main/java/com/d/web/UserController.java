package com.d.web;

import com.d.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @ApiOperation("加积分")
    @GetMapping(path = "/score/increase")
    public Integer increaseScore(Long id, Integer score) {
        try {
            return userService.increaseScore(id, score);
        } catch (Exception e) {
            return 0;
        }
    }
}
