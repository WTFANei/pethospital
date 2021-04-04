package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.dto.MedicineDto;
import cn.anei.pethospital.entity.Medicine;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamMedicine;
import cn.anei.pethospital.repository.MedicineRepository;
import cn.anei.pethospital.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
            Medicine medicine = medicineRepository.findById(id);
            medicine.setStatus(1);
            medicineRepository.save(medicine);
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
            m.setStatus(medicine.getStatus());
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
    public Map<String, Object> getMedicinesByCond(SearchParamMedicine searchParamMedicine) {
        PageRequest pageRequest = new PageRequest(searchParamMedicine.getPage(), searchParamMedicine.getSize());
        Medicine cond = searchParamMedicine.getMedicine();
        if(cond != null){
            Specification<Medicine> query = new Specification<Medicine>() {
                @Override
                public Predicate toPredicate(Root<Medicine> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicates = new ArrayList<>();
                    if(!StringUtils.isEmpty(cond.getName())){
                        predicates.add(criteriaBuilder.like(root.get("name"), "%" + cond.getName() + "%"));
                    }
                    if(!StringUtils.isEmpty(cond.getText())){
                        predicates.add(criteriaBuilder.like(root.get("text"), "%" + cond.getText() + "%"));
                    }
                    if(!StringUtils.isEmpty(cond.getNum())){
                        predicates.add(criteriaBuilder.greaterThan(root.get("num"), cond.getNum()));
                    }
                    if(!StringUtils.isEmpty(cond.getStatus())){
                        predicates.add(criteriaBuilder.equal(root.get("status"), cond.getStatus()));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            };
            Page<Medicine> medicines = medicineRepository.findAll(query,pageRequest);
            return medicines(medicines);
        }
        Page<Medicine> medicines = medicineRepository.findAll(pageRequest);
        return medicines(medicines);
    }

    @Override
    public Medicine getMedicine(String id) {
        Medicine m = medicineRepository.findById(id);
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
