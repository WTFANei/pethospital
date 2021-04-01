package cn.anei.pethospital.vo;


import lombok.Data;

/**
 * @Author: ANei
 * @Description: http请求返回的最外层对象
 * @Data: 下午6:39 17/9/16
 */


@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private T data;

}

