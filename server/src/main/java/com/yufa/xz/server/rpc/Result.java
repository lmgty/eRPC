package com.yufa.xz.server.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author admin
 * @data 2020/7/30
 */
@Data
@AllArgsConstructor
public class Result {
    private Boolean success;

    private String message;

    private String resultType;

    private String resultValue;


    public static Result getSuccessResult(String resultType, String resultValue) {
        return new Result(true, "成功", resultType, resultValue);
    }

    public static Result getFailResult(String reason) {
        return new Result(false, reason, null, null);
    }
    public Boolean isSuccess() {
        return success;
    }
}
