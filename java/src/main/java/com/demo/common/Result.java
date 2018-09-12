package com.demo.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result {
    private String resultCode;
    private String resultDes;

    public static final String SUCCESS_CODE = "1";// 返回结果正确代码
    public static final String SUCCESS_DESC = "success";// 返回结果正确描述

    public static final String ERROR_CODE = "0";// 返回结果错误代码
    public static final String ERROR_DESC = "error";// 返回结果默认错误描述

    private static final Result RESULT_SUCCESS = new Result(SUCCESS_CODE, SUCCESS_DESC);

    public Result(String resultCode, String resultDes) {
        this.resultCode = resultCode;
        this.resultDes = resultDes;
    }

    public static Result success() {
        return RESULT_SUCCESS;
    }

    /**
     * 
     * errorResult:返回错误结果.<br/>
     * 
     * @author huliujie
     * @return
     */
    public static Result error() {
        return new Result(ERROR_CODE, ERROR_DESC);
    }

    /**
     * 
     * errorResult:返回自定义错误描述结果.<br/>
     * 
     * @author huliujie
     * @param errorDesc
     * @return
     */
    public static Result error(String errorDesc) {
        return new Result(ERROR_CODE, errorDesc);
    }

    public static Result success(String succDesc) {
        return new Result(SUCCESS_CODE, succDesc);
    }
}