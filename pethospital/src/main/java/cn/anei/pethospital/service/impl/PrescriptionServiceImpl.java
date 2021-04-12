package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.dto.PrescriptionDto;
import cn.anei.pethospital.entity.Medicine;
import cn.anei.pethospital.entity.Order;
import cn.anei.pethospital.entity.Prescription;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamPrescription;
import cn.anei.pethospital.repository.MedicineRepository;
import cn.anei.pethospital.repository.OrderRepository;
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
import java.util.*;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Boolean prescriptionAdd(Prescription prescription) {
        if (prescriptionRepository.findById(prescription.getId())!=null) {
            return false;
        }else {
            try{
                String orderId = prescription.getOid();
                Order order = orderRepository.findById(orderId);
                if(null != order && (order.getStatus() == 1 || order.getStatus() == 2)){
                    return false;
                }

                Date time = new Date();
                String mid = prescription.getMid();
                Integer mnum = prescription.getMnum();
                Medicine medicine = medicineRepository.findById(mid);
                if(null == medicine){
                    return false;
                }
                Integer num = medicine.getNum();
                Integer remainderNum = num - mnum;
                if (remainderNum < 0) {
                    return false;
                }
                Double medicinePrice = medicine.getPrice();
                Double cprice = medicinePrice * mnum;
                prescription.setCpirce(cprice);
                prescription.setPtime(time);

                medicine.setNum(remainderNum);
                medicineRepository.save(medicine);

                prescriptionRepository.save(prescription);
                return true;
            }catch (Exception e){
                return false;
            }
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
        Prescription p = prescriptionRepository.findByIdAndStatus(id, "0");
        if(p != null){
            return true;
        }else{
            return  false;
        }
    }


    @Override
    public Boolean prescriptionModify(Prescription prescription) {
        Prescription p = prescriptionRepository.findOne(prescription.getId());

        if (p!=null){
            try{
                String orderId = prescription.getOid();
                Order order = orderRepository.findById(orderId);
                if(null != order && (order.getStatus() == 1 || order.getStatus() == 2)){
                    return false;
                }

                Date time = new Date();
                String oldMid = p.getMid();
                Integer oldMnum = p.getMnum();
                String newMid = prescription.getMid();
                Integer newMnum = prescription.getMnum();

                if(oldMid == newMid && oldMnum == newMnum){
                    return false;
                }

                Medicine oldMedicine = medicineRepository.findById(oldMid);
                if(null == oldMedicine){
                    return false;
                }
                Integer oldNum = oldMedicine.getNum();
                Integer oldRemainderNum = oldNum + oldMnum;

                Medicine newMedicine = medicineRepository.findById(oldMid);
                if(null == newMedicine){
                    return false;
                }
                Integer newNum = newMedicine.getNum();
                Integer newRemainderNum = newNum - newMnum;
                if (newRemainderNum < 0) {
                    return false;
                }

                Double medicinePrice = newMedicine.getPrice();
                Double cprice = medicinePrice * newMnum;

                oldMedicine.setNum(oldRemainderNum);
                newMedicine.setNum(newRemainderNum);
                medicineRepository.save(oldMedicine);
                medicineRepository.save(newMedicine);

                p.setMid(newMid);
                p.setMnum(newMnum);
                p.setCpirce(cprice);
                p.setPtime(time);
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
