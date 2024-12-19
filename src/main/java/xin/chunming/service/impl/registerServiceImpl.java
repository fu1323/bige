package xin.chunming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xin.chunming.mapper.registMapper;
import xin.chunming.pojo.User;
import xin.chunming.service.registerService;

import java.util.List;

@Service
public class registerServiceImpl implements registerService {
    @Autowired
    registMapper rm;

    @Override
    public List<User> findbyUserName(String username) {
        return rm.selectByName(username);
    }

    @Override
    public void register(String userName,String password) {
       rm.registInsert(userName, password);
    }
}
