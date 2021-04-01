package cn.anei.pethospital.service;

import cn.anei.pethospital.entity.Medicine;
import cn.anei.pethospital.param.SearchParam;

import java.util.Map;

public interface MedicineService {

    Boolean medicineAdd(Medicine medicine);

    Boolean medicineDelete(String id);

    Boolean medicineModify(Medicine medicine);

    Map<String, Object> getMedicines(SearchParam searchParam);

    Medicine getMedicine(Medicine medicine);

}
