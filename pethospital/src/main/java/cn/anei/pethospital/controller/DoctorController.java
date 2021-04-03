package cn.anei.pethospital.controller;

import cn.anei.pethospital.entity.Doctor;
import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamDoctor;
import cn.anei.pethospital.service.DoctorService;
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
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctorLogin")
    public ResultVO adminLogin(@RequestBody @Valid Doctor doctor,HttpSession session) {
        Doctor doctor1 = doctorService.existDoctor(doctor);
        if (doctor1!=null){
            session.setAttribute("doctor", doctor);
            return ResultVOUtil.success(doctor1);
        }
        return ResultVOUtil.error(1,"登陆失败！");
    }

    @PostMapping("/doctorModifyPwd")
    public ResultVO doctorModifyPwd(@RequestBody @Valid RePwdParam rePwdParam, HttpSession session) {
        Doctor doctor =(Doctor) session.getAttribute("doctor");
        System.out.println(rePwdParam);
        return doctorService.modifyPwd(rePwdParam,doctor)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }

    @PostMapping("/doctorAdd")
    public ResultVO doctorAdd(@RequestBody @Valid Doctor doctor, HttpSession session) {
        Object sess = session.getAttribute("admin");
        if(null == sess){
            return ResultVOUtil.error(1,"管理员请先登录！"); //越权操作，跳转到管理员登录界面
        }
        return doctorService.doctorAdd(doctor)? ResultVOUtil.success("新增成功！"):ResultVOUtil.error(1,"新增失败！");
    }

    @PostMapping("/doctorDelete")
    public ResultVO doctorDelete(@RequestParam("id") String doctorId, HttpSession session) {
        Object sess = session.getAttribute("admin");
        if(null == sess){
            return ResultVOUtil.error(1,"管理员请先登录！"); //越权操作，跳转到管理员登录界面
        }
        return doctorService.doctorDelete(doctorId)? ResultVOUtil.error(1, "删除失败！") : ResultVOUtil.success("删除成功！");

    }
    @PostMapping("/doctorModify")
    public ResultVO doctorModify(@RequestBody @Valid Doctor doctor, HttpSession session) {
        Object sess = session.getAttribute("admin");
        if(null == sess){
            return ResultVOUtil.error(1,"管理员请先登录！"); //越权操作，跳转到管理员登录界面
        }
        return doctorService.doctorModify(doctor)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }

    @PostMapping("/getDoctors")
    public ResultVO getDoctors(@RequestBody @Valid SearchParam searchParam) {
        Map<String, Object> doctors = doctorService.getDoctors(searchParam);
        return doctors != null ? ResultVOUtil.success(doctors) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getDoctor")
    public ResultVO getDoctor(@RequestBody @Valid Doctor doctor) {
        Doctor d = doctorService.getDoctor(doctor);
        return d != null ? ResultVOUtil.success(d) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getDoctorsByCond")
    public ResultVO getDoctorsByCond(@RequestBody @Valid SearchParamDoctor searchParamDoctor) {
        Map<String, Object> doctors = doctorService.getDoctorsByCond(searchParamDoctor);
        return doctors != null ? ResultVOUtil.success(doctors) : ResultVOUtil.error(1, "信息获取失败！");
    }

}
