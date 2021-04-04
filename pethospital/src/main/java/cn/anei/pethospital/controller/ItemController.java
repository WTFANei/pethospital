package cn.anei.pethospital.controller;

import cn.anei.pethospital.entity.Item;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamItem;
import cn.anei.pethospital.service.ItemService;
import cn.anei.pethospital.util.ResultVOUtil;
import cn.anei.pethospital.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;


@RestController
//@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/itemAdd")
    public ResultVO itemAdd(@RequestBody @Valid Item item, HttpSession session) {
        Object sess = session.getAttribute("admin");
        if(null == sess){
            return ResultVOUtil.error(1,"管理员请先登录！"); //越权操作，跳转到管理员登录界面
        }
        return itemService.itemAdd(item)? ResultVOUtil.success("新增成功！"):ResultVOUtil.error(1,"新增失败！");
    }

    @PostMapping("/itemDelete")
    public ResultVO itemDelete(@RequestParam("id") String itemId, HttpSession session) {
        Object sess = session.getAttribute("admin");
        if(null == sess){
            return ResultVOUtil.error(1,"管理员请先登录！"); //越权操作，跳转到管理员登录界面
        }
        return itemService.itemDelete(itemId)? ResultVOUtil.error(1, "删除失败！") : ResultVOUtil.success("删除成功！");

    }
    @PostMapping("/itemModify")
    public ResultVO itemModify(@RequestBody @Valid Item item, HttpSession session) {
        Object sess = session.getAttribute("admin");
        if(null == sess){
            return ResultVOUtil.error(1,"管理员请先登录！"); //越权操作，跳转到管理员登录界面
        }
        return itemService.itemModify(item)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }

    @PostMapping("/getItems")
    public ResultVO getItems(@RequestBody @Valid SearchParam searchParam) {
        Map<String, Object> items = itemService.getItems(searchParam);
        return items != null ? ResultVOUtil.success(items) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getItem")
    public ResultVO getItem(@RequestParam("id") String id) {
        Item i = itemService.getItem(id);
        return i != null ? ResultVOUtil.success(i) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getItemsByCond")
    public ResultVO getItemsByCond(@RequestBody @Valid SearchParamItem searchParamItem) {
        Map<String, Object> items = itemService.getItemsByCond(searchParamItem);
        return items != null ? ResultVOUtil.success(items) : ResultVOUtil.error(1, "信息获取失败！");
    }
}
