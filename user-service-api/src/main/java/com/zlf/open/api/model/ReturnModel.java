package com.zlf.open.api.model;

import com.zlf.open.api.utils.DateUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 返回值数据模型
 * Created by pengshen on 2016/11/3.
 */
@Data
public class ReturnModel implements Serializable {
    private int code;
    private String msg;
    private Object data;
    private Long responsetime;

    public ReturnModel() {
        this.code = 1;
        this.msg = "请求成功！";
        this.data = null;
        this.responsetime = DateUtil.getLongTime(DateUtil.getDateString(new Date()));
    }

    public ReturnModel(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.responsetime = DateUtil.getLongTime(DateUtil.getDateString(new Date()));
    }


}
