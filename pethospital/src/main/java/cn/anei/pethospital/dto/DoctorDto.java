package cn.anei.pethospital.dto;

import cn.anei.pethospital.entity.Doctor;
import lombok.Data;

import java.util.Date;


@Data
public class DoctorDto {

    private String id;
    private String account;
    private String name;
    private Date birth;
    private String pwd;
    private Integer status;


    public DoctorDto(Doctor doctor) {
        this.id = doctor.getId();
        this.account = doctor.getAccount();
        this.name = doctor.getName();
        this.birth = doctor.getBirth();
        this.pwd = doctor.getPwd();
        this.status = doctor.getStatus();
    }
}
