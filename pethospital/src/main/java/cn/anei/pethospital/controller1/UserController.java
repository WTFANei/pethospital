package cn.anei.pethospital.controller1;

import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.service.UserService;
import cn.anei.pethospital.util.ResultVOUtil;
import cn.anei.pethospital.entity.User;
import cn.anei.pethospital.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

/**
 * @Author: ANei
 * @Date: 下午2:21 18/2/20
 * @Description:
 */

@RestController
@RequestMapping("/c")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody @Valid User user,HttpSession session) {
        User u = userService.existUser(user);
        if (u!=null){
            session.setAttribute("user", u);
            return ResultVOUtil.success(u);
        }
        return ResultVOUtil.error(1,"账户或密码错误！");
    }

    @PostMapping("/register")
    public ResultVO register(@RequestBody @Valid User user) {
        return userService.register(user)? ResultVOUtil.success("注册成功！"):ResultVOUtil.error(1,"注册失败！");
    }

    @PostMapping("/updateUserInfo")
    public ResultVO updateUserInfo(@RequestBody @Valid User user) {
        return userService.updateInfo(user)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }

    @PostMapping("/modifyPwd")
    public ResultVO modifyPwd(@RequestBody @Valid RePwdParam rePwdParam, HttpSession session) {
        User user =(User) session.getAttribute("user");
        return userService.modifyPwd(rePwdParam,user)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }

    @PostMapping("/becomeAuthor")
    public ResultVO becomeAuthor(@RequestBody @Valid User user) {
        return userService.becomeAuthor(user)? ResultVOUtil.success("提交成功！"):ResultVOUtil.error(1,"提交失败！");
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

    @PostMapping("/userCheck")
    public ResultVO userCheck(@RequestBody @Valid SearchParam searchParam) {
        Map<String, Object> users = userService.getCheckUsers(searchParam);
        return users != null ? ResultVOUtil.success(users) : ResultVOUtil.error(1, "信息获取失败！");
    }


    @GetMapping("/accessUser")
    public ResultVO accessUser(@RequestParam("id") String uid) {
        return userService.accessUserByuid(uid) ? ResultVOUtil.success("审核成功！"):ResultVOUtil.error(1, "审核失败！");
    }

    @GetMapping("/notAccessUser")
    public ResultVO notAccessUser(@RequestParam("id") String uid) {
        return userService.notAccessUserByuid(uid) ? ResultVOUtil.success("审核成功！"):ResultVOUtil.error(1, "审核失败！");
    }

    @GetMapping("/removeUser")
    public ResultVO removeUser(@RequestParam("id") String uid) {
            return userService.removeUserByuid(uid) ? ResultVOUtil.error(1, "删除失败！") : ResultVOUtil.success("删除成功！");
    }

}
