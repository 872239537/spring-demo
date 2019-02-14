package com.threeeye.demo.api.controller;

import com.threeeye.framework.exception.ErrMsgEnum;

public enum HbtErrMsgEnum implements ErrMsgEnum {
    NUMBER_NULL("80001","序号不能为空"),

    SAVE_REPORT_CORE_DATA_NULL("90001","保存上报的核心数据为空")
    ;

    private String errCode;
    private String errMsg;

    HbtErrMsgEnum(String errCode, String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
