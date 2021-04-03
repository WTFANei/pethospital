package cn.anei.pethospital.service;

import cn.anei.pethospital.entity.Prescription;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamPrescription;

import java.util.Map;

public interface PrescriptionService {

    Boolean prescriptionAdd(Prescription prescription);

    Boolean prescriptionDelete(String id);

    Boolean prescriptionModify(Prescription prescription);

    Map<String, Object> getPrescriptions(SearchParam searchParam);

    Map<String, Object> getPrescriptionsByCond(SearchParamPrescription searchParamPrescription);

    Prescription getPrescription(Prescription prescription);

}
