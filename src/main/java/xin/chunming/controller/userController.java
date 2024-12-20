package xin.chunming.controller;

import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.chunming.pojo.Result;
import xin.chunming.pojo.User;
import xin.chunming.service.impl.userServiceImpl;
import xin.chunming.utils.JwtUtil;

import java.util.HashMap;

@Validated
@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    userServiceImpl reg;

    @PostMapping("/register")
    public Result regist(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        if (!reg.findbyUserName(username).isEmpty()) {
            return Result.error("己存在");
        } else {
            reg.register(username, password);
            return Result.success();
        }

    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        User login = reg.login(username, password);
        if (login != null) {
            HashMap<String, Object> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("id", login.getId());
            stringStringHashMap.put("username", login.getUsername());

            return Result.success(JwtUtil.genToken(stringStringHashMap));
        } else return Result.error("用户名密码错误");
    }
    @GetMapping("/111")
    public Result l() {
        return Result.success("121212121");
    }
}
