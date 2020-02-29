package com.zlf.user.core.controller;

import com.zlf.open.api.model.ReturnModel;
import com.zlf.open.api.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @CrossOrigin
    @RequestMapping("/userLogin")
    public ReturnModel userLoginC(String username, String password) {
        return userService.userLogin(username, password);
    }

    @CrossOrigin
    @RequestMapping("/getUserById")
    public ReturnModel getUserByIdC(int id){
        return userService.getUserById(id);
    }

    @CrossOrigin
    @RequestMapping("/listUserBlurName")
    public Map<String,Object> listUserBlurNameC(String username, @RequestParam("page")int page,@RequestParam("rows") int rows){
        return userService.listBlurUserByUsername(username,page,rows);
    }

    @CrossOrigin
    @RequestMapping("/getUserByName")
    public ReturnModel getUserByNameC(String username){
        return userService.getUserByUsername(username);
    }

    @CrossOrigin
    @RequestMapping("/updateUserByPK")
    public ReturnModel updateUserByPKC(int id,String password){
        return userService.updateUserByPK(id,password);
    }

    @CrossOrigin
    @RequestMapping("/delUserByPK")
    public ReturnModel delUserByPKC(int id){ //or by id
        return userService.delUserByPK(id);
    }

    @CrossOrigin
    @RequestMapping("/delUserBatchPKs")
    public ReturnModel delUserBatchPKsC(@RequestParam("ids[]") int[] ids){
        System.out.println("core:ids:"+ids.toString());
        return userService.delUserBatchPKs(ids);
    }

    @CrossOrigin
    @RequestMapping("/addUser")
    public ReturnModel addUser(String username,String password){
        return userService.addUser(username,password);
    }

}
