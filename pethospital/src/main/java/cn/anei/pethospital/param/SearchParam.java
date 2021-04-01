package cn.anei.pethospital.param;

import lombok.Data;

/**
 * @Author: ANei
 * @Date: 下午3:32 18/3/6
 * @Description:
 */

@Data
public class SearchParam {
    String param;
    Integer flag=0;
    Integer page = 0;
    Integer size = 10;
}
