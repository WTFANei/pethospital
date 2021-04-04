package cn.anei.pethospital.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "orderinfo")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Order {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "order_id",length = 32)
    private String id;
    @Column(name = "item_id",length = 32)
    private String iid;
    @Column(name = "user_id",length = 32)
    private String uid;
    @Column(name = "pet_id",length = 32)
    private String pid;
    @Column(name = "doctor_id",length = 32)
    private String did;
    @Column(name = "order_text",length = 500)
    private String text;
    @Column(name = "order_time")
    private Date otime;
    @Column(name = "finish_time")
    private Date ftime;
    @Column(name = "is_finish")
    private Integer isfinish;
    @Column(name = "status",length = 1)
    private Integer status;
}
