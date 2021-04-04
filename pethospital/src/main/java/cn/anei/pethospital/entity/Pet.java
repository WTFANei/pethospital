package cn.anei.pethospital.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "pet")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Pet {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "pet_id",length = 32)
    private String id;
    @Column(name = "user_id",length = 11)
    private String uid;
    @Column(name = "pet_name",length = 32)
    private String name;
    @Column(name = "pet_age",length = 2)
    private Integer age;
    @Column(name = "pet_sex",length = 1)
    private Integer sex;
    @Column(name = "status",length = 1)
    private Integer status = 0;
}
