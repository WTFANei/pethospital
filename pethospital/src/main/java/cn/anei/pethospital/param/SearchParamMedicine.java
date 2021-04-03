package cn.anei.pethospital.param;

import cn.anei.pethospital.entity.Medicine;
import lombok.Data;


@Data
public class SearchParamMedicine extends SearchParam{
    Medicine medicine;
}
