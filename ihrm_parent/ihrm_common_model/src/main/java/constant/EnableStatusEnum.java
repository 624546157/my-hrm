package constant;

import com.ihrm.common.entity.CodeEnum;

/**
 * @author wuzebin
 * @title: EnableStatusEnum
 * @projectName ihrm_parent
 * @description:
 * @date 2019/9/1914:40
 */
public enum EnableStatusEnum implements CodeEnum {

    ALREADY_ENABLE("1", "已经启用（未删除）"),
    NOT_ENABLE("0", "未启用（已经删除）");


    private String code;

    private String msg;

    EnableStatusEnum(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取编码
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取中文描述
     *
     * @return
     */
    public String getMsg() {
        return msg;
    }


}
