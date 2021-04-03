package cn.anei.pethospital.param;

import cn.anei.pethospital.entity.Prescription;
import lombok.Data;


@Data
public class SearchParamPrescription extends SearchParam{
    Prescription prescription;
}
