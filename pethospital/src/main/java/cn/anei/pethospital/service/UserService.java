package cn.anei.pethospital.service;

import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.entity.User;

import java.util.Map;

public interface UserService {

    User existUser(User user);

    Boolean register(User user);

    Boolean modifyPwd(RePwdParam rePwdParam, User user);

    Boolean userDelete(String id);

    Boolean userModify(User user);

    Map<String, Object> getUsers(SearchParam searchParam);

    User getUser(User user);

}
