package cn.anei.pethospital.dto;

import cn.anei.pethospital.entity.User;
import lombok.Data;

import java.util.Date;


@Data
public class UserDto {

    private String id;
    private String phone;
    private String name;
    private String pwd;

    public UserDto(User user){
        this.id = user.getId();
        this.phone = user.getPhone();
        this.name = user.getName();
        this.pwd = user.getPwd();
    }
}
