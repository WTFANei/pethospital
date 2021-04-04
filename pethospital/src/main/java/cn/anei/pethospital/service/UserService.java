package cn.anei.pethospital.service;

import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.entity.User;
import cn.anei.pethospital.param.SearchParamUser;

import java.util.Map;

public interface UserService {

    User existUser(User user);

    Boolean register(User user);

    Boolean modifyPwd(RePwdParam rePwdParam, User user);

    Boolean userDelete(String id);

    Boolean userModify(User user);

    Map<String, Object> getUsers(SearchParam searchParam);

    Map<String, Object> getUsersByCond(SearchParamUser searchParamUser);

    User getUser(String id);

}
