package cn.anei.pethospital.service;

import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.entity.Admin;

public interface AdminService {
    Admin existUser(Admin admin);

    Boolean modifyPwd(RePwdParam rePwdParam, Admin admin);
}
