package com.zlf.open.user.dao.mysql;

import com.zlf.open.api.domain.User;
import com.zlf.open.api.model.ReturnModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //通过用户名密码获取用户
    User selectUserByUsernamePassword(@Param("username") String username, @Param("password") String password);
    //通过用户id获取用户
    User getUserById(Integer id);
    //根据用户名模糊查询
    List<User> selectUserByBlurUsername(String username);
    //通过用户名获取用户
    User selectUserByUsername(String username);

    Integer insertUser(String username,String password);

    Integer updateUserPasswordById(Integer id,String password);

    Integer deleteUserById(Integer id);

    Integer deleteUserBatchByPKArr(@Param("ids") int[] ids);

}
