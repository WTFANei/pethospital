package cn.anei.pethospital.controller;

import cn.anei.pethospital.entity.CountData;
import cn.anei.pethospital.service.CountService;
import cn.anei.pethospital.util.ResultVOUtil;
import cn.anei.pethospital.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
//@RequestMapping("/api")
public class CountController {
    @Autowired
    private CountService countService;

    @PostMapping("/getCountItemForUser")
    public ResultVO getCountItemForUser(@RequestParam("userId") String userId, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, HttpSession session) {
//        Object sess = session.getAttribute("user");
//        if(null == sess){
//            return ResultVOUtil.error(1,"用户请先登录！"); //越权操作，跳转到用户登录界面
//        }
        List<CountData> countData = countService.getCountItemForUser(userId, startDate, endDate);
        return countData != null ? ResultVOUtil.success(countData) : ResultVOUtil.error(1, "统计信息获取失败！");
    }

    @PostMapping("/getCountMedicineForUser")
    public ResultVO getCountMedicineForUser(@RequestParam("userId") String userId, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, HttpSession session) {
//        Object sess = session.getAttribute("user");
//        if(null == sess){
//            return ResultVOUtil.error(1,"用户请先登录！"); //越权操作，跳转到用户登录界面
//        }
        List<CountData> countData = countService.getCountMedicineForUser(userId, startDate, endDate);
        return countData != null ? ResultVOUtil.success(countData) : ResultVOUtil.error(1, "统计信息获取失败！");
    }

    @PostMapping("/getCountItemForAdmin")
    public ResultVO getCountItemForAdmin(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, HttpSession session) {
//        Object sess = session.getAttribute("admin");
//        if(null == sess){
//            return ResultVOUtil.error(1,"管理员请先登录！"); //越权操作，跳转到管理员登录界面
//        }
        List<CountData> countData = countService.getCountItemForAdmin(startDate, endDate);
        return countData != null ? ResultVOUtil.success(countData) : ResultVOUtil.error(1, "统计信息获取失败！");
    }

    @PostMapping("/getCountMedicineForAdmin")
    public ResultVO getCountMedicineForAdmin(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, HttpSession session) {
//        Object sess = session.getAttribute("admin");
//        if(null == sess){
//            return ResultVOUtil.error(1,"管理员请先登录！"); //越权操作，跳转到管理员登录界面
//        }
        List<CountData> countData = countService.getCountMedicineForAdmin(startDate, endDate);
        return countData != null ? ResultVOUtil.success(countData) : ResultVOUtil.error(1, "统计信息获取失败！");
    }

}
