package xin.chunming.controller;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xin.chunming.pojo.Result;
import xin.chunming.pojo.User;
import xin.chunming.service.impl.userServiceImpl;
import xin.chunming.utils.JwtUtil;
import xin.chunming.utils.Md5Util;
import xin.chunming.utils.ThreadLocalUtil;

import java.util.HashMap;
import java.util.Map;

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

    @PatchMapping("/updatePWD")
    public Result updatepwd(@RequestParam String old_pwd, @RequestParam String new_pwd, @RequestParam String re_pwd) {
        if (!new_pwd.equals(re_pwd)) {
            return Result.error("两次密码不一致!");
        } else {
            Map<String, Object> stringObjectMap = ThreadLocalUtil.get();
            String uname = (String) stringObjectMap.get("username");
            if (Md5Util.checkPassword(old_pwd, reg.findbyUserName(uname).get(0).getPassword())) {

                reg.updatePwd(Md5Util.getMD5String(new_pwd), uname);

                return Result.success();
            } else return Result.error("原密码错误");
        }

    }

    @PatchMapping("/updateAvator")
    public Result updateAvator(@RequestParam @URL String avatar) {
        Map<String, Object> o = (Map<String, Object>) ThreadLocalUtil.get();
        reg.updateAvator(avatar, String.valueOf((Integer) o.get("id")));
        return Result.success();
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

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User u) {
        reg.update(u);
        return Result.success();

    }

    @GetMapping("/userinfo")
    public Result<User> userinfo(@RequestHeader(name = "Authorization") String token) {
        Map<String, Object> stringObjectMap = JwtUtil.parseToken(token);
        String username = (String) stringObjectMap.get("username");
        return Result.success(reg.findbyUserName(username).get(0));

    }

    @GetMapping("/111")
    public Result l() {
        return Result.success("121212121");
    }
}
