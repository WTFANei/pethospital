package cn.anei.pethospital.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
public class CountData {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "count")
    private String count;
    @Column(name = "name")
    private String name;
}
