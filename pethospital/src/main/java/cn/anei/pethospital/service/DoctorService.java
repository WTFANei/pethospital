package cn.anei.pethospital.service;

import cn.anei.pethospital.entity.Doctor;
import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamDoctor;

import java.util.Map;

public interface DoctorService {
    Doctor existDoctor(Doctor doctor);

    Boolean modifyPwd(RePwdParam rePwdParam, Doctor doctor);

    Boolean doctorAdd(Doctor doctor);

    Boolean doctorDelete(String id);

    Boolean doctorModify(Doctor doctor);

    Map<String, Object> getDoctors(SearchParam searchParam);

    Map<String, Object> getDoctorsByCond(SearchParamDoctor searchParamDoctor);

    Doctor getDoctor(String id);

}
