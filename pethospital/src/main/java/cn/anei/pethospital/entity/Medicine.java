package cn.anei.pethospital.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "medicine")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Medicine {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "medicine_id",length = 32)
    private String id;
    @Column(name = "medicine_name",length = 32)
    private String name;
    @Column(name = "medicine_text",length = 500)
    private String text;
    @Column(name = "medicine_num",length = 4)
    private Integer num;
    @Column(name = "medicine_price")
    private Double price;

}
