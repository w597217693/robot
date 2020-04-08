package com.bigcat.app.controller;

import com.bigcat.app.dto.GlobalCacheInfo;
import com.bigcat.app.dto.User;
import com.bigcat.app.dto.UserDTO;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.ConstantUtils;
import com.bigcat.app.utils.RestResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/robot-app")
public class UserController {

    @PostMapping("/login")
    public RestResult loginValidate(@RequestBody User user){
        // 将传递的用户信息放置到内存中
        GlobalCacheInfo.getInfo().setUser(user);
        return RestResult.build();
    }

    @GetMapping("/start")
    public RestResult startGame(@RequestParam(defaultValue = "-1") Integer start){
        GlobalCacheInfo.getInfo().setGameIng(start);
        return RestResult.build();
    }



}
