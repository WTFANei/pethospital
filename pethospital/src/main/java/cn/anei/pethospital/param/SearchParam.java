package cn.anei.pethospital.param;

import lombok.Data;


@Data
public class SearchParam {
    String param;
    Object object;
    Integer flag = 0;
    Integer page = 0;
    Integer size = 10;
}
