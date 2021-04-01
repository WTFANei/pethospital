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
        medicineRepository.delete(id);
        return medicineRepository.exists(id) ? true : false;
    }


    @Override
    public Boolean medicineModify(Medicine medicine) {
        Medicine d = medicineRepository.findOne(medicine.getId());
        if (d!=null){
            d.setName(medicine.getName());
            d.setText(medicine.getText());
            try{
                medicineRepository.save(d);
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
            medicines = medicineRepository.findAllByNameLike("%" + searchParam.getParam() + "%", pageRequest);
        } else {
            medicines = medicineRepository.findAll(pageRequest);
        }
        return medicines(medicines);
    }

    @Override
    public Medicine getMedicine(Medicine medicine) {
        Medicine d = medicineRepository.findById(medicine.getId());
        return d;
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
