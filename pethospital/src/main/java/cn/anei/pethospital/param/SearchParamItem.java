package cn.anei.pethospital.param;

import cn.anei.pethospital.entity.Item;
import lombok.Data;


@Data
public class SearchParamItem extends SearchParam{
    Item item;
}
