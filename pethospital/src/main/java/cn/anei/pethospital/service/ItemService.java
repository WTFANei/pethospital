package cn.anei.pethospital.service;

import cn.anei.pethospital.entity.Item;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamItem;

import java.util.Map;

public interface ItemService {

    Boolean itemAdd(Item item);

    Boolean itemDelete(String id);

    Boolean itemModify(Item item);

    Map<String, Object> getItems(SearchParam searchParam);

    Map<String, Object> getItemsByCond(SearchParamItem searchParamItem);

    Item getItem(Item item);

}
