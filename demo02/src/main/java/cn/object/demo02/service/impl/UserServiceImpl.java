package cn.object.demo02.service.impl;

import cn.object.demo02.domain.User;
import cn.object.demo02.mapper.UserMapper;
import cn.object.demo02.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public User getUsersById(String userId) {
        return userMapper.getUsersById(userId);
    }

    @Override
    public User getUsersByName(String userName) {
        return userMapper.getUsersByName(userName);
    }

    @Override
    public List<User> getUsersByIdAndName(String userId, String userName) {
        return userMapper.getUsersByIdAndName(userId,userName);
    }

    @Override
    public Boolean SignIn(String userName, String password){
        return userMapper.SignIn(userName,password) == 1;
    }

}
