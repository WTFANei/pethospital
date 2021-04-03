package cn.anei.pethospital.param;

import lombok.Data;


@Data
public class SearchParam {
    String param;
    Integer page = 0;
    Integer size = 10;
}
