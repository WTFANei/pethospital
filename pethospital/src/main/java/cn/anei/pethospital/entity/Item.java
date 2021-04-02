package cn.anei.pethospital.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "item")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Item {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "item_id",length = 32)
    private String id;
    @Column(name = "item_name",length = 32)
    private String name;
    @Column(name = "item_text",length = 500)
    private String text;
    @Column(name = "item_num")
    private Integer num;
    @Column(name = "item_price")
    private Double price;

}
