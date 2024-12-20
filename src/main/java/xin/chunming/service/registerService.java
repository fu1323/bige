package xin.chunming.service;

import xin.chunming.pojo.User;

import java.util.List;

public interface registerService {
    List<User> findbyUserName(String username);
    void register(String userName,String password);
    User login(String userName,String password);

}
