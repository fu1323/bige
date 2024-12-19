package xin.chunming.controller;

import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.chunming.pojo.Result;
import xin.chunming.service.impl.registerServiceImpl;
import xin.chunming.service.registerService;
@Validated
@RestController
@RequestMapping("/user")
public class register {
    @Autowired
    registerServiceImpl reg;

    @PostMapping("/register")
    public Result regist(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password) {
        if (!reg.findbyUserName(username).isEmpty()) {
            return Result.error("己存在");
        } else {
            reg.register(username, password);
            return Result.success();
        }

    }
}
