package xin.chunming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.chunming.mapper.userMapper;
import xin.chunming.pojo.User;
import xin.chunming.service.registerService;
import xin.chunming.utils.Md5Util;

import java.util.List;

@Service
public class userServiceImpl implements registerService {
    @Autowired
    userMapper rm;

    @Override
    public List<User> findbyUserName(String username) {
        return rm.selectByName(username);
    }

    @Override
    public void register(String userName, String password) {
        rm.registInsert(userName, Md5Util.getMD5String(password));
    }

    @Override
    public User login(String userName, String password) {
        List<User> users = rm.select2Login(userName, Md5Util.getMD5String(password));
        return users.isEmpty() ? null : users.getFirst();

    }

    @Override
    public void update(User u) {
        rm.update(u);
    }
}
