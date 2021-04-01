package cn.anei.itemhospital.controller;

import cn.anei.pethospital.entity.Item;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.service.ItemService;
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
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/itemAdd")
    public ResultVO itemADD(@RequestBody @Valid Item item) {
        return itemService.itemAdd(item)? ResultVOUtil.success("新增成功！"):ResultVOUtil.error(1,"新增失败！");
    }

    @PostMapping("/itemDelete")
    public ResultVO itemDelete(@RequestParam("id") String itemId) {
        return itemService.itemDelete(itemId)? ResultVOUtil.error(1, "删除失败！") : ResultVOUtil.success("删除成功！");

    }
    @PostMapping("/itemModify")
    public ResultVO itemModify(@RequestBody @Valid Item item) {
        return itemService.itemModify(item)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }

    @PostMapping("/getItems")
    public ResultVO getItems(@RequestBody @Valid SearchParam searchParam) {
        Map<String, Object> items = itemService.getItems(searchParam);
        return items != null ? ResultVOUtil.success(items) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getItem")
    public ResultVO getItem(@RequestBody @Valid Item item) {
        Item d = itemService.getItem(item);
        return d != null ? ResultVOUtil.success(d) : ResultVOUtil.error(1, "信息获取失败！");
    }

}
