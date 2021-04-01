package cn.anei.pethospital.dto;

import cn.anei.pethospital.entity.User;
import lombok.Data;

import java.util.Date;

/**
 * @Author: ANei
 * @Date: 下午3:36 18/3/6
 * @Description:
 */

@Data
public class UserDto {

    private String uid;
    private String name;
    private String realName;
    private String email;
    private String cardNum;
    private String cardPic;
    private Date birth;
    private String sex;
    private Integer type;

    public UserDto(User user){
        this.uid = user.getUid();
        this.name = user.getName();
        this.realName = user.getRealName();
        this.email = user.getEmail();
        this.cardNum = user.getCardNum();
        this.cardPic = user.getCardPic();
        this.birth = user.getBirth();
        this.sex = user.getSex();
        this.type = user.getType();
    }
}
