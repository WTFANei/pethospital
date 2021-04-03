package cn.anei.pethospital.param;

import cn.anei.pethospital.entity.Doctor;
import lombok.Data;


@Data
public class SearchParamDoctor extends SearchParam{
    Doctor doctor;
}
