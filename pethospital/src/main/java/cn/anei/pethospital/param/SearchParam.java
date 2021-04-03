package cn.anei.pethospital.param;

import lombok.Data;


@Data
public class SearchParam {
    String param;
    Integer flag = 0;
    Integer page = 0;
    Integer size = 10;
}
