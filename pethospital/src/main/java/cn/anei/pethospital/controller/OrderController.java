package cn.anei.pethospital.controller;

import cn.anei.pethospital.entity.Order;
import cn.anei.pethospital.param.OrderCommitParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamOrder;
import cn.anei.pethospital.service.OrderService;
import cn.anei.pethospital.util.ResultVOUtil;
import cn.anei.pethospital.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;


@RestController
//@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orderAdd")
    public ResultVO orderAdd(@RequestBody @Valid Order order) {
        return orderService.orderAdd(order)? ResultVOUtil.success("新增成功！"):ResultVOUtil.error(1,"新增失败！");
    }

    @PostMapping("/orderCommit")
    public ResultVO orderCommit(@RequestBody @Valid OrderCommitParam orderCommitParam) {
        return orderService.orderCommit(orderCommitParam)? ResultVOUtil.success("提交成功！"):ResultVOUtil.error(1,"提交失败！");
    }

    @PostMapping("/orderDelete")
    public ResultVO orderDelete(@RequestParam("id") String orderId) {
        return orderService.orderDelete(orderId)? ResultVOUtil.error(1, "删除失败！") : ResultVOUtil.success("删除成功！");

    }
    @PostMapping("/orderModify")
    public ResultVO orderModify(@RequestBody @Valid Order order) {
        return orderService.orderModify(order)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }

    @PostMapping("/getOrders")
    public ResultVO getOrders(@RequestBody @Valid SearchParam searchParam) {
        Map<String, Object> orders = orderService.getOrders(searchParam);
        return orders != null ? ResultVOUtil.success(orders) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getOrder")
    public ResultVO getOrder(@RequestBody @Valid Order order) {
        Order d = orderService.getOrder(order);
        return d != null ? ResultVOUtil.success(d) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getOrdersByDid")
    public ResultVO getOrdersByDid(@RequestBody @Valid SearchParam searchParam) {
        Map<String, Object> orders = orderService.getOrdersByDid(searchParam);
        return orders != null ? ResultVOUtil.success(orders) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getOrdersByDidPreOrder")
    public ResultVO getOrdersByDidPreOrder(@RequestBody @Valid SearchParam searchParam) {
        Map<String, Object> orders = orderService.getOrdersByDidPreOrder(searchParam);
        return orders != null ? ResultVOUtil.success(orders) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getOrdersByCond")
    public ResultVO getOrdersByCond(@RequestBody @Valid SearchParamOrder SearchParamOrder) {
        Map<String, Object> orders = orderService.getOrdersByCond(SearchParamOrder);
        return orders != null ? ResultVOUtil.success(orders) : ResultVOUtil.error(1, "信息获取失败！");
    }


}
