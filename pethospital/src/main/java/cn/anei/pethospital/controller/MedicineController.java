package cn.anei.pethospital.controller;

import cn.anei.pethospital.entity.Medicine;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.service.MedicineService;
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
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @PostMapping("/medicineAdd")
    public ResultVO medicineAdd(@RequestBody @Valid Medicine medicine) {
        return medicineService.medicineAdd(medicine)? ResultVOUtil.success("新增成功！"):ResultVOUtil.error(1,"新增失败！");
    }

    @PostMapping("/medicineDelete")
    public ResultVO medicineDelete(@RequestParam("id") String medicineId) {
        return medicineService.medicineDelete(medicineId)? ResultVOUtil.error(1, "删除失败！") : ResultVOUtil.success("删除成功！");

    }
    @PostMapping("/medicineModify")
    public ResultVO medicineModify(@RequestBody @Valid Medicine medicine) {
        return medicineService.medicineModify(medicine)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }

    @PostMapping("/getMedicines")
    public ResultVO getMedicines(@RequestBody @Valid SearchParam searchParam) {
        Map<String, Object> medicines = medicineService.getMedicines(searchParam);
        return medicines != null ? ResultVOUtil.success(medicines) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getMedicine")
    public ResultVO getMedicine(@RequestBody @Valid Medicine medicine) {
        Medicine d = medicineService.getMedicine(medicine);
        return d != null ? ResultVOUtil.success(d) : ResultVOUtil.error(1, "信息获取失败！");
    }

}
