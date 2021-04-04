package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.entity.CountData;
import cn.anei.pethospital.repository.CountRepository;
import cn.anei.pethospital.service.CountService;
import cn.anei.pethospital.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CountServiceImpl implements CountService {

    @Autowired
    private CountRepository countRepository;

    @Override
    public List<CountData> getCountItemForUser(String userId, String startDate, String endDate) {
        try {
            Date start = DateUtil.String2Date(startDate);
            Date end = DateUtil.String2Date(endDate);
            return countRepository.getCountItemForUser(userId, start, end);
        } catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }

    @Override
    public List<CountData> getCountMedicineForUser(String userId, String startDate, String endDate) {
        try {
            Date start = DateUtil.String2Date(startDate);
            Date end = DateUtil.String2Date(endDate);
            return countRepository.getCountMedicineForUser(userId, start, end);
        } catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }

    @Override
    public List<CountData> getCountItemForAdmin(String startDate, String endDate) {
        try {
            Date start = DateUtil.String2Date(startDate);
            Date end = DateUtil.String2Date(endDate);
            return countRepository.getCountItemForAdmin(start, end);
        } catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }

    @Override
    public List<CountData> getCountMedicineForAdmin(String startDate, String endDate) {
        try {
            Date start = DateUtil.String2Date(startDate);
            Date end = DateUtil.String2Date(endDate);
            return countRepository.getCountMedicineForAdmin(start, end);
        } catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }

}
