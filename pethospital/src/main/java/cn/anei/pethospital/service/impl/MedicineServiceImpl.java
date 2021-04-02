package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.dto.MedicineDto;
import cn.anei.pethospital.entity.Medicine;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.repository.MedicineRepository;
import cn.anei.pethospital.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Boolean medicineAdd(Medicine medicine) {
        if (medicineRepository.findById(medicine.getId())!=null) {
            return false;
        }else {
            medicineRepository.save(medicine);
            return true;
        }
    }


    @Override
    public Boolean medicineDelete(String id) {
        try {
            medicineRepository.delete(id);
        }
        catch (Exception e){
            return true;
        }
        return medicineRepository.exists(id) ? true : false;
    }


    @Override
    public Boolean medicineModify(Medicine medicine) {
        Medicine m = medicineRepository.findOne(medicine.getId());
        if (m!=null){
            m.setName(medicine.getName());
            m.setText(medicine.getText());
            m.setNum(medicine.getNum());
            m.setPrice(medicine.getPrice());
            try{
                medicineRepository.save(m);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> getMedicines(SearchParam searchParam) {
        PageRequest pageRequest = new PageRequest(searchParam.getPage(), searchParam.getSize());
        Page<Medicine> medicines;
        if (searchParam.getParam() != null) {
            medicines = medicineRepository.findAllByNameContaining(searchParam.getParam(), pageRequest);
        } else {
            medicines = medicineRepository.findAll(pageRequest);
        }
        return medicines(medicines);
    }

    @Override
    public Medicine getMedicine(Medicine medicine) {
        Medicine m = medicineRepository.findById(medicine.getId());
        return m;
    }

    public Map<String, Object> medicines(Page<Medicine> medicines){
        if (medicines != null) {
            Map<String, Object> map = new HashMap<>();
            List<MedicineDto> medicineDtos = new ArrayList<>();
            for (Medicine medicine : medicines) {
                medicineDtos.add(new MedicineDto(medicine));
            }
            map.put("totalElements", medicines.getTotalElements());
            map.put("content", medicineDtos);
            return map;
        }
        return null;
    }

}
