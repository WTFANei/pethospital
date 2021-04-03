package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.util.MD5Util;
import cn.anei.pethospital.entity.Admin;
import cn.anei.pethospital.repository.AdminRepository;
import cn.anei.pethospital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ANei
 * @Date: 下午2:56 18/3/6
 * @Description:
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public Admin existUser(Admin admin) {
        Admin a = adminRepository.findByAccountAndPwd(admin.getAccount(), admin.getPwd());
        if (a!=null) {
            a.setPwd(null);
            return a;
        }
        return null;
    }

    @Override
    public Boolean modifyPwd(RePwdParam rePwdParam, Admin admin) {
        System.out.println(admin);
        if (admin == null)
            return false;

        Admin a = adminRepository.findByAccountAndPwd(admin.getAccount(),rePwdParam.getPwd());
        if (a!=null){
            try{
                a.setPwd(rePwdParam.getNewPwd());
                adminRepository.save(a);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }
}
