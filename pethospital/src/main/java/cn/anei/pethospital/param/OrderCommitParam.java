package cn.anei.pethospital.param;

import cn.anei.pethospital.entity.Order;
import cn.anei.pethospital.entity.Prescription;
import lombok.Data;

import java.util.List;

@Data
public class OrderCommitParam {
    Order order;
    List<Prescription> prescriptionList;
}
