package com.zlf.open.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlf.open.api.code.CommonCode;
import com.zlf.open.api.domain.User;
import com.zlf.open.api.model.ReturnModel;
import com.zlf.open.api.service.UserService;
import com.zlf.open.user.bll.UserBll;
import org.jboss.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController implements UserService {

    @Autowired
    private UserBll userBll;

    @Override
    public ReturnModel userLogin(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return new ReturnModel(CommonCode.FAIL_CODE, null, CommonCode.FORM_FAIL);
        }
        User user = userBll.userLogin(username, password);
        if (user == null) {//登录失败
            return new ReturnModel(CommonCode.FAIL_CODE, null, CommonCode.LOGIN_FAIL);
        }
        //登录成功
        return new ReturnModel(CommonCode.SUCCESS_CODE, null, CommonCode.LOGIN_SUCCESS);
    }

    @Override
    public ReturnModel getUserById(Integer id) {
        if (id == null || id < 0) {
            return new ReturnModel(CommonCode.FAIL_CODE, null, CommonCode.FAIL_MSG);
        } else {
            User userById = userBll.getUserById(id);
            if (userById == null) {//获取失败
                return new ReturnModel(CommonCode.FAIL_CODE, null, CommonCode.NONE_DATA);
            } else {
                return new ReturnModel(CommonCode.SUCCESS_CODE, userById, CommonCode.SELECT_OK);
            }
        }
    }

    @Override
    public Map<String, Object> listBlurUserByUsername(String username, int page, int rows) {
        page = page < 0 ? page = 1 : page;
        rows = rows < 0 ? rows = 10 : rows;
        Map<String, Object> resultMap = new HashMap<>();
        PageHelper.startPage(page, rows);
        List<User> users = userBll.listBlurUserByUsername(username);
        if (users.size() > 0) {
            PageInfo<User> pageInfo = new PageInfo<User>(users);
            resultMap.put("rows", pageInfo.getList());
            resultMap.put("total", pageInfo.getTotal());
            return resultMap;
        } else {
            return null;
        }
    }

    @Override
    public ReturnModel getUserByUsername(String username) {
        User userByUsername = userBll.getUserByUsername(username);
        if (userByUsername == null) {
            return new ReturnModel(CommonCode.FAIL_CODE, null, CommonCode.NONE_DATA);
        } else {
            return new ReturnModel(CommonCode.SUCCESS_CODE, userByUsername, CommonCode.SELECT_OK);
        }
    }

    @Override
    public ReturnModel updateUserByPK(Integer id, String password) {
        if (id == null || id < 0 || StringUtils.isEmpty(password)) {//用户密码不能改为空
            return new ReturnModel(CommonCode.FAIL_CODE, null, CommonCode.FAIL_MSG);
        } else {
            int updateCode = userBll.updateUserPWD(id, password);
            if (updateCode > 0) {
                return new ReturnModel(CommonCode.SUCCESS_CODE, updateCode, CommonCode.UPDATE_OK);
            } else {
                return new ReturnModel(CommonCode.FAIL_CODE, updateCode, CommonCode.UPDATE_FAIL);
            }
        }
    }

    @Override
    public ReturnModel delUserByPK(Integer id) {
        if (id == null || id < 0) {
            return new ReturnModel(CommonCode.FAIL_CODE, null, CommonCode.FAIL_MSG);
        } else {
            int deleteCode = userBll.delUser(id);
            if (deleteCode > 0) {
                return new ReturnModel(CommonCode.SUCCESS_CODE, deleteCode, CommonCode.DELETE_OK);
            } else {
                return new ReturnModel(CommonCode.FAIL_CODE, deleteCode, CommonCode.DELETE_FAIL);
            }
        }
    }

    @Override
    public ReturnModel delUserBatchPKs(int[] ids) {
        if (ids == null || ids.length == 0) {
            return new ReturnModel(CommonCode.FAIL_CODE, null, CommonCode.FAIL_MSG);
        } else {
            int deleteCode = userBll.deleteUserBatch(ids);
            if (deleteCode > 0) {
                return new ReturnModel(CommonCode.SUCCESS_CODE, deleteCode, CommonCode.DELETE_OK);
            } else {
                return new ReturnModel(CommonCode.FAIL_CODE, deleteCode, CommonCode.DELETE_FAIL);
            }
        }
    }

    @Override
    public ReturnModel addUser(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return new ReturnModel(CommonCode.FAIL_CODE, null, CommonCode.FAIL_MSG);
        } else {
            int insertCode = userBll.insertUserSelect(username, password);
            if (insertCode > 0) {
                return new ReturnModel(CommonCode.SUCCESS_CODE, insertCode, CommonCode.INSERT_OK);
            } else {
                return new ReturnModel(CommonCode.FAIL_CODE, insertCode, CommonCode.INSERT_FAIL);
            }
        }
    }

}
