package cn.anei.pethospital.param;

import cn.anei.pethospital.entity.User;
import lombok.Data;


@Data
public class SearchParamUser extends SearchParam{
    User user;
}
