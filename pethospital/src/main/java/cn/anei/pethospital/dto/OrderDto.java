package cn.anei.pethospital.dto;

import cn.anei.pethospital.entity.Order;
import lombok.Data;

import java.util.Date;


@Data
public class OrderDto {

    private String id;
    private String iid;
    private String uid;
    private String pid;
    private String did;
    private String text;
    private Date otime;
    private Date ftime;
    private Integer isfinish;


    public OrderDto(Order order) {
        this.id = order.getId();
        this.iid = order.getIid();
        this.uid = order.getUid();
        this.pid = order.getPid();
        this.did = order.getDid();
        this.text = order.getText();
        this.otime = order.getOtime();
        this.ftime = order.getFtime();
        this.isfinish = order.getIsfinish();
    }
}
