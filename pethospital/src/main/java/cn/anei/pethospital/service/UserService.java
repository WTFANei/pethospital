package cn.anei.pethospital.service;

import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.entity.User;

import java.util.Map;

public interface UserService {

    User existUser(User user);

    Boolean register(User user);

    Boolean updateInfo(User user);

    Boolean becomeAuthor(User user);

    Map<String, Object> getUsers(SearchParam searchParam);

    User getUser(User user);

    Map<String, Object> getCheckUsers(SearchParam searchParam);

    Boolean removeUserByuid(String uid);

    Boolean modifyPwd(RePwdParam rePwdParam, User user);

    Boolean accessUserByuid(String uid);

    Boolean notAccessUserByuid(String uid);
}
