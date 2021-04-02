package cn.anei.pethospital.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "doctor")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Doctor {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "doctor_id",length = 32)
    private String id;
    @Column(name = "doctor_account",length = 32)
    private String account;
    @Column(name = "doctor_name",length = 32)
    private String name;
    @Column(name = "doctor_pwd",length = 32)
    private String pwd;
    @Column(name = "doctor_birth")
    private Date birth;
}
