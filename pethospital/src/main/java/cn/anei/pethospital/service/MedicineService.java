package cn.anei.pethospital.service;

import cn.anei.pethospital.entity.Medicine;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamMedicine;

import java.util.Map;

public interface MedicineService {

    Boolean medicineAdd(Medicine medicine);

    Boolean medicineDelete(String id);

    Boolean medicineModify(Medicine medicine);

    Map<String, Object> getMedicines(SearchParam searchParam);

    Map<String, Object> getMedicinesByCond(SearchParamMedicine searchParamMedicine);


    Medicine getMedicine(Medicine medicine);

}
