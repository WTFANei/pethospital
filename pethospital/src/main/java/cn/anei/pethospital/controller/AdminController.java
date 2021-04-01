package cn.anei.pethospital.controller;

import cn.anei.pethospital.entity.Admin;
import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.service.AdminService;
import cn.anei.pethospital.util.ResultVOUtil;
import cn.anei.pethospital.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Author: ANei
 * @Date: 下午2:59 18/3/6
 * @Description:
 */
@RestController
//@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/adminLogin")
    public ResultVO adminLogin(@RequestBody @Valid Admin admin,HttpSession session) {
        Admin admin1 = adminService.existUser(admin);
        if (admin1!=null){
            session.setAttribute("admin", admin);
            return ResultVOUtil.success(admin1);
        }
        return ResultVOUtil.error(1,"登陆失败！");
    }

    @PostMapping("/adminModifyPwd")
    public ResultVO adminModifyPwd(@RequestBody @Valid RePwdParam rePwdParam, HttpSession session) {
        Admin admin =(Admin) session.getAttribute("admin");
        System.out.println(rePwdParam);
        return adminService.modifyPwd(rePwdParam,admin)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }
}
