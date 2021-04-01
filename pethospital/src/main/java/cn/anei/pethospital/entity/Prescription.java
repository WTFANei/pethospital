package cn.anei.pethospital.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "prescription")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Prescription {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "prescription_id",length = 32)
    private String id;
    @Column(name = "order_id",length = 32)
    private String oid;
    @Column(name = "medicine_id",length = 32)
    private String mid;
    @Column(name = "medicine_num",length = 5)
    private Integer mnum;
    @Column(name = "count_price")
    private Double cpirce;
}
