package cn.anei.pethospital.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "user_id",length = 32)
    private String id;
    @Column(name = "user_phone",length = 11)
    private String phone;
    @Column(name = "user_name",length = 30)
    private String name;
    @Column(name = "user_pwd",length = 32)
    private String pwd;
}
