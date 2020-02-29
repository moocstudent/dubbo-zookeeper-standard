package com.zlf.open.user.bll;

import com.zlf.open.api.domain.User;
import com.zlf.open.user.dao.mysql.UserMapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBll {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public User userLogin(String username, String password) {
        return userMapper.selectUserByUsernamePassword(username, password);
    }

    /**
     * 通过id获取用户
     * @param id
     * @return User
     */
    public User getUserById(int id){
        return userMapper.getUserById(id);
    }

    /**
     * 通过username模糊查询用户表
     * @param username
     * @return List<User>
     */
    public List<User> listBlurUserByUsername(String username){
        return userMapper.selectUserByBlurUsername(username);
    }

    /**
     * 通过username获取用户
     * @param username
     * @return User
     */
    public User getUserByUsername(String username){
        return userMapper.selectUserByUsername(username);
    }

    public Integer insertUserSelect(String username,String password){
        return userMapper.insertUser(username,password);
    }

    public Integer updateUserPWD(int id,String password){
        return userMapper.updateUserPasswordById(id,password);
    }

    public Integer delUser(int id){
        return userMapper.deleteUserById(id);
    }

    public Integer deleteUserBatch(int[] ids){
        return userMapper.deleteUserBatchByPKArr(ids);
    }

}
