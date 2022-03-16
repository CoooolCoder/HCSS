package cn.object.demo02.mapper;

import cn.object.demo02.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    @Select("select * from T_User")
    List<User> getAllUsers();

    @Select("select * from T_User where userId = #{userId}")
    User getUsersById(String userId);

    @Select("select * from T_User where userName = #{userName}")
    User getUsersByName(String userName);

    @Select("select * from T_User where userId = #{userId} and userName = #{userName} ")
    List<User> getUsersByIdAndName(/*@Param("userId")*/ String userId, String userName);

    @Select("select count(*) from T_User where userName = #{userName} and password = #{password}")
    Integer SignIn(String userName,String password);


}

