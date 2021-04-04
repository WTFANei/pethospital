package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.dto.PrescriptionDto;
import cn.anei.pethospital.entity.Medicine;
import cn.anei.pethospital.entity.Prescription;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamPrescription;
import cn.anei.pethospital.repository.MedicineRepository;
import cn.anei.pethospital.repository.PrescriptionRepository;
import cn.anei.pethospital.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Boolean prescriptionAdd(Prescription prescription) {
        if (prescriptionRepository.findById(prescription.getId())!=null) {
            return false;
        }else {
            String mid = prescription.getMid();
            Integer mnum = prescription.getMnum();
            Medicine medicine = medicineRepository.findById(mid);
            Integer num = medicine.getNum();
            Integer remainderNum = num - mnum;
            if (remainderNum < 0) {
                return false;
            }
            Double medicinePrice = medicine.getPrice();
            Double cprice = medicinePrice * mnum;
            prescription.setCpirce(cprice);
            prescriptionRepository.save(prescription);
            medicine.setNum(remainderNum);
            medicineRepository.save(medicine);
            return true;
        }
    }


    @Override
    public Boolean prescriptionDelete(String id) {
        try {
            Prescription prescription = prescriptionRepository.findById(id);
            prescription.setStatus(1);
            prescriptionRepository.save(prescription);
        }
        catch (Exception e){
            return true;
        }
        return prescriptionRepository.exists(id) ? true : false;
    }


    @Override
    public Boolean prescriptionModify(Prescription prescription) {
        Prescription p = prescriptionRepository.findOne(prescription.getId());
        if (p!=null){
            p.setMid(prescription.getMid());
            p.setMnum(prescription.getMnum());
            p.setCpirce(prescription.getCpirce());
            p.setStatus(prescription.getStatus());
            try{
                prescriptionRepository.save(p);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> getPrescriptions(SearchParam searchParam) {
        PageRequest pageRequest = new PageRequest(searchParam.getPage(), searchParam.getSize());
        Page<Prescription> prescriptions = prescriptionRepository.findAll(pageRequest);
        return prescriptions(prescriptions);
    }


    @Override
    public Map<String, Object> getPrescriptionsByCond(SearchParamPrescription searchParamPrescription) {
        Sort.Direction sort =  Sort.Direction.DESC;
        PageRequest pageRequest = new PageRequest(searchParamPrescription.getPage(), searchParamPrescription.getSize(), sort , "otime");
        Prescription cond = searchParamPrescription.getPrescription();
        if(cond != null){
            Specification<Prescription> query = new Specification<Prescription>() {
                @Override
                public Predicate toPredicate(Root<Prescription> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicates = new ArrayList<>();
                    if(!StringUtils.isEmpty(cond.getOid())){
                        predicates.add(criteriaBuilder.equal(root.get("oid"),cond.getOid()));
                    }
                    if(!StringUtils.isEmpty(cond.getStatus())){
                        predicates.add(criteriaBuilder.equal(root.get("status"), cond.getStatus()));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            };
            Page<Prescription> prescriptions = prescriptionRepository.findAll(query,pageRequest);
            return prescriptions(prescriptions);
        }
        Page<Prescription> prescriptions = prescriptionRepository.findAll(pageRequest);
        return prescriptions(prescriptions);
    }

    @Override
    public Prescription getPrescription(String id) {
        Prescription p = prescriptionRepository.findById(id);
        return p;
    }

    public Map<String, Object> prescriptions(Page<Prescription> prescriptions){
        if (prescriptions != null) {
            Map<String, Object> map = new HashMap<>();
            List<PrescriptionDto> prescriptionDtos = new ArrayList<>();
            for (Prescription prescription : prescriptions) {
                prescriptionDtos.add(new PrescriptionDto(prescription));
            }
            map.put("totalElements", prescriptions.getTotalElements());
            map.put("content", prescriptionDtos);
            return map;
        }
        return null;
    }

}
