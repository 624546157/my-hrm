package com.ihrm.common.entity;

/**
 * 公共的返回码
 *    返回码code：
 *      成功：10000
 *      失败：10001
 *      未登录：10002
 *      未授权：10003
 *      抛出异常：99999
 */
public enum ResultEnum {

    SUCCESS(00,"操作成功！"),
    //---系统错误返回码-----
    FAIL(-1,"操作失败"),
    UNAUTHENTICATED(100002,"您还未登录"),
    UNAUTHORISE(100003,"权限不足"),
    SERVER_ERROR(999999,"抱歉，系统繁忙，请稍后重试！"),



    /**
     * 内部异常
     */
    ERROR_CODE_500(500, "内部异常"),
    /**
     * @author WFZ
     */
    ILLEGAL_DATA_ERROR(-2, "操作失败,传入非法参数"),

    PARAM_ERROR(1000, "请求参数错误"),

    REQUEST_GET_SUPPORTED(1001, "请求不支持GET，请使用POST"),

    REQUEST_POST_SUPPORTED(1002, "请求不支持POST，请使用GET"),

    TYPE_CONVERT_ERROR(8888, "参数类型转换错误"),

    EXCEPTION(9999, "接口请求异常"),

    /**
     * @author WFZ  HttpRequestMethodNotSupportedException
     */
    HTTP_REQUEST_METHOD_EXCEPTION(10204001, "请求方法错误"),

    /**
     * @author WFZ  MissingServletRequestParameterException
     */
    REQUEST_PARAMETER_EXCEPTION(10204002, "缺少请求参数错误"),

    /**
     * @author WFZ  SQLSyntaxErrorException  SQL异常
     */
    SQL_SYNTAX_EXCEPTION(10204003, "SQL异常"),

    /**
     * @author WFZ  全局EXCEPTION
     */
    GLOBAL_EXCEPTION(10204004, "系统忙，请稍后再试或联系管理员"),

    /**
     * @author WFZ
     */
    MAX_ADD_QUICK_MODULE_ERROR(30204001, "工作台最多支持添加11个功能，如需继续添加，请先移出不常用的功能"),
    /**
     * @author WFZ
     */
    MINIMUN_ONLY_ONE_ERROR(30204002, "请至少保留一个快捷功能"),

    /**
     * 参数输入不合法！
     */
    SYSTEM_SERVER_20204001(20204001, "参数输入不合法");
    //---用户操作返回码  2xxxx----
    //---企业操作返回码  3xxxx----
    //---权限操作返回码----
    //---其他操作返回码----




    //操作代码
    int code;
    //提示信息
    String message;

    ResultEnum(int code, String message){
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return message;
    }

}
