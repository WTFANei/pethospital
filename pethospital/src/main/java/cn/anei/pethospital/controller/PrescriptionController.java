package cn.anei.pethospital.controller;

import cn.anei.pethospital.entity.Prescription;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamPrescription;
import cn.anei.pethospital.service.PrescriptionService;
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
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping("/prescriptionAdd")
    public ResultVO prescriptionAdd(@RequestBody @Valid Prescription prescription, HttpSession session) {
        Object sess = session.getAttribute("doctor");
        Object sess1 = session.getAttribute("admin");
        if(null == sess && null == sess1){
            return ResultVOUtil.error(1,"医生请先登录！"); //越权操作，跳转到医生登录界面
        }
        return prescriptionService.prescriptionAdd(prescription)? ResultVOUtil.success("新增成功！"):ResultVOUtil.error(1,"新增失败！");
    }

    @PostMapping("/prescriptionDelete")
    public ResultVO prescriptionDelete(@RequestParam("id") String prescriptionId, HttpSession session) {
        Object sess = session.getAttribute("doctor");
        Object sess1 = session.getAttribute("admin");
        if(null == sess && null == sess1){
            return ResultVOUtil.error(1,"医生请先登录！"); //越权操作，跳转到医生登录界面
        }
        return prescriptionService.prescriptionDelete(prescriptionId)? ResultVOUtil.error(1, "删除失败！") : ResultVOUtil.success("删除成功！");

    }
    @PostMapping("/prescriptionModify")
    public ResultVO prescriptionModify(@RequestBody @Valid Prescription prescription, HttpSession session) {
        Object sess = session.getAttribute("doctor");
        Object sess1 = session.getAttribute("admin");
        if(null == sess && null == sess1){
            return ResultVOUtil.error(1,"医生请先登录！"); //越权操作，跳转到医生登录界面
        }
        return prescriptionService.prescriptionModify(prescription)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }

    @PostMapping("/getPrescriptions")
    public ResultVO getPrescriptions(@RequestBody @Valid SearchParam searchParam) {
        Map<String, Object> prescriptions = prescriptionService.getPrescriptions(searchParam);
        return prescriptions != null ? ResultVOUtil.success(prescriptions) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getPrescription")
    public ResultVO getPrescription(@RequestParam("id") String id) {
        Prescription d = prescriptionService.getPrescription(id);
        return d != null ? ResultVOUtil.success(d) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getPrescriptionsByCond")
    public ResultVO getPrescriptionsByCond(@RequestBody @Valid SearchParamPrescription SearchParamPrescription) {
        Map<String, Object> prescriptions = prescriptionService.getPrescriptionsByCond(SearchParamPrescription);
        return prescriptions != null ? ResultVOUtil.success(prescriptions) : ResultVOUtil.error(1, "信息获取失败！");
    }


}
