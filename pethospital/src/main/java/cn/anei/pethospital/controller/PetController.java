package cn.anei.pethospital.controller;

import cn.anei.pethospital.entity.Pet;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamPet;
import cn.anei.pethospital.service.PetService;
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
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping("/petAdd")
    public ResultVO petAdd(@RequestBody @Valid Pet pet, HttpSession session) {
        Object sess = session.getAttribute("user");
        Object sess1 = session.getAttribute("admin");
        if(null == sess && null == sess1){
            return ResultVOUtil.error(1,"用户请先登录！"); //越权操作，跳转到用户登录界面
        }
        return petService.petAdd(pet)? ResultVOUtil.success("新增成功！"):ResultVOUtil.error(1,"新增失败！");
    }

    @PostMapping("/petDelete")
    public ResultVO petDelete(@RequestParam("id") String petId, HttpSession session) {
        Object sess = session.getAttribute("user");
        Object sess1 = session.getAttribute("admin");
        if(null == sess && null == sess1){
            return ResultVOUtil.error(1,"用户请先登录！"); //越权操作，跳转到用户登录界面
        }
        return petService.petDelete(petId)? ResultVOUtil.error(1, "删除失败！") : ResultVOUtil.success("删除成功！");

    }
    @PostMapping("/petModify")
    public ResultVO petModify(@RequestBody @Valid Pet pet, HttpSession session) {
        Object sess = session.getAttribute("user");
        Object sess1 = session.getAttribute("admin");
        if(null == sess && null == sess1){
            return ResultVOUtil.error(1,"用户请先登录！"); //越权操作，跳转到用户登录界面
        }
        return petService.petModify(pet)? ResultVOUtil.success("修改成功！"):ResultVOUtil.error(1,"修改失败！");
    }

    @PostMapping("/getPets")
    public ResultVO getPets(@RequestBody @Valid SearchParam searchParam) {
        Map<String, Object> pets = petService.getPets(searchParam);
        return pets != null ? ResultVOUtil.success(pets) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getPet")
    public ResultVO getPet(@RequestBody @Valid Pet pet) {
        Pet p = petService.getPet(pet);
        return p != null ? ResultVOUtil.success(p) : ResultVOUtil.error(1, "信息获取失败！");
    }

    @PostMapping("/getPetsByCond")
    public ResultVO getPetsByCond(@RequestBody @Valid SearchParamPet searchParamPet) {
        Map<String, Object> pets = petService.getPetsByCond(searchParamPet);
        return pets != null ? ResultVOUtil.success(pets) : ResultVOUtil.error(1, "信息获取失败！");
    }

}
