package com.ihrm.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据响应对象
 *    {
 *      success ：是否成功
 *      code    ：返回码
 *      message ：返回信息
 *      //返回数据
 *      data：  ：{
 *
 *      }
 *    }
 */
@Data
@NoArgsConstructor
public class Result<T> {

    private Integer code;// 返回码
    private String message;//返回信息
    private Object data;// 返回数据

    public Result(ResultEnum code) {
        this.code = code.code;
        this.message = code.message;
    }

    public Result(ResultEnum code,Object data) {
        this.code = code.code;
        this.message = code.message;
        this.data = data;
    }

    public Result(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> failed(ResultEnum codeEnum) {
        return new Result<T>(codeEnum.getCode(), codeEnum.getMsg());
    }

    public static <T> Result<T> failedWith( Integer code, String msg ,T data) {
        return new Result<T>(code, msg, data);
    }

    public static Result ERROR(){
        return new Result(ResultEnum.SERVER_ERROR);
    }

    public static Result FAIL(){
        return new Result(ResultEnum.FAIL);
    }
}
