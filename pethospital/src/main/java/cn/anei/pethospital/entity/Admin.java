package cn.anei.pethospital.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "admin")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Admin {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "admin_id",length = 32)
    private String id;
    @Column(name = "admin_account",length = 32)
    private String account;
    @Column(name = "admin_name",length = 32)
    private String name;
    @Column(name = "admin_pwd",length = 16)
    private String pwd;
    @Column(name = "status",length = 1)
    private Integer status;

}
