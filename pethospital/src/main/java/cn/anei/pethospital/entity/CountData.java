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
    private Long count;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
}
