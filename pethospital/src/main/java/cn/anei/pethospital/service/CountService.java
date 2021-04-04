package cn.anei.pethospital.service;

import cn.anei.pethospital.entity.CountData;

import java.util.List;

public interface CountService {

    List<CountData> getCountItemForUser(String userId, String startDate, String endDate);

    List<CountData> getCountMedicineForUser(String userId, String startDate, String endDate);

    List<CountData> getCountItemForAdmin(String startDate, String endDate);

    List<CountData> getCountMedicineForAdmin(String startDate, String endDate);

}
