package cn.anei.pethospital.service;

import cn.anei.pethospital.entity.Order;
import cn.anei.pethospital.param.OrderCommitParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamOrder;

import java.util.Map;

public interface OrderService {

    Boolean orderAdd(Order order);

    Boolean orderCommit(OrderCommitParam orderCommitParam);

    Boolean orderDelete(String id);

    Boolean orderModify(Order order);

    Map<String, Object> getOrders(SearchParam searchParam);

//    Map<String, Object> getOrders();

    Map<String, Object> getOrdersByDid(SearchParam searchParam);

    Map<String, Object> getOrdersByDidPreOrder(SearchParam searchParam);

    Map<String, Object> getOrdersByCond(SearchParamOrder searchParamOrder);

    Order getOrder(String id);

}
