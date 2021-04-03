package cn.anei.pethospital.param;

import cn.anei.pethospital.entity.Order;
import lombok.Data;


@Data
public class SearchParamOrder extends SearchParam{
    Order order;
}
