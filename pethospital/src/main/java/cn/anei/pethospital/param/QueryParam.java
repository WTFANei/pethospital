package cn.anei.pethospital.param;

import lombok.Data;

/**
 * @Author: ANei
 * @Date: 下午1:08 18/2/6
 * @Description:
 */
@Data
public class QueryParam {
    Integer page = 0;
    Integer size = 10;
    String paramId;
    String mixParam;
    Boolean fo = false;
}
