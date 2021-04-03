package cn.anei.pethospital.controller;

import cn.anei.pethospital.entity.User;
import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamUser;
import cn.anei.pethospital.service.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/userLogin")
    public ResultVO adminLogin(@RequestBody @Valid User user,HttpSession session) {
        User user1 = userService.existUser(user);
        if (user1!=null){
            session.setAttribute("user", user);
            return ResultVOUtil.success(user1);
        }
        return ResultVOUtil.error(1,"登陆失败！");
    }

    @PostMapping("/userModifyPwd")
    public ResultVO userModifyPwd(@RequestBody @Valid RePwdParam rePwdParam, HttpSession session) {
        User user =(User) session.getAttribute("user");
        System.out.println(rePwdParam);
        return userService.modifyPwd(rePwdParam,user)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }

    @PostMapping("/userDelete")
    public ResultVO userDelete(@RequestParam("id") String userId, HttpSession session) {
        Object sess = session.getAttribute("admin");
        if(null == sess){
            return ResultVOUtil.error(1,"管理员请先登录！"); //越权操作，跳转到管理员登录界面
        }
        return userService.userDelete(userId)? ResultVOUtil.error(1, "删除失败！") : ResultVOUtil.success("删除成功！");

    }
    @PostMapping("/userModify")
    public ResultVO userModify(@RequestBody @Valid User user, HttpSession session) {
        Object sess = session.getAttribute("user");
        Object sess1 = session.getAttribute("admin");
        if(null == sess && null == sess1){
            return ResultVOUtil.error(1,"用户请先登录！"); //越权操作，跳转到用户登录界面
        }
        return userService.userModify(user)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }

    @PostMapping("/getUsers")
    public ResultVO getUsers(@RequestBody @Valid SearchParam searchParam) {
        Map<String, Object> users = userService.getUsers(searchParam);
        return users != null ? ResultVOUtil.success(users) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getUser")
    public ResultVO getUser(@RequestBody @Valid User user) {
        User u = userService.getUser(user);
        return u != null ? ResultVOUtil.success(u) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/register")
    public ResultVO register(@RequestBody @Valid User user) {
        return userService.register(user)? ResultVOUtil.success("注册成功！"):ResultVOUtil.error(1,"注册失败！");
    }

    @PostMapping("/getUsersByCond")
    public ResultVO getPetsByCond(@RequestBody @Valid SearchParamUser searchParamUser) {
        Map<String, Object> users = userService.getUsersByCond(searchParamUser);
        return users != null ? ResultVOUtil.success(users) : ResultVOUtil.error(1, "信息获取失败！");
    }
}
