package cn.object.demo02.service;

import cn.object.demo02.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUsersById(String userId);

    User getUsersByName(String userName);

    List<User> getUsersByIdAndName(String userId,String userName);

    Boolean SignIn(String userName,String password);
}
