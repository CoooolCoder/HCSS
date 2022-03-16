package cn.object.demo02.controller;

import cn.object.demo02.domain.User;
import cn.object.demo02.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/signIn",method = RequestMethod.POST)
    public String SignIn(@RequestBody User user){
        boolean isOk = false;
        isOk = userService.SignIn(user.getUserName(),user.getPassword());
        if(isOk == true)
            return "Successfully Sign In ! UserName:"+user.getUserName();
        else
            return "Sign In Failure";

    }

}
