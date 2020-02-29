package com.zlf.open.api.service;

import com.zlf.open.api.domain.User;
import com.zlf.open.api.model.ReturnModel;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface UserService {

    ReturnModel userLogin(String username, String password);

    ReturnModel getUserById(Integer id);

    Map<String,Object> listBlurUserByUsername(String username,@RequestParam("page") int page, @RequestParam("rows")int rows);

    ReturnModel getUserByUsername(String username);

    ReturnModel updateUserByPK(Integer id,String password);

    ReturnModel delUserByPK(Integer id);

    ReturnModel delUserBatchPKs(int[] ids);

    ReturnModel addUser(String username,String password);

}
