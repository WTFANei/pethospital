package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.dto.DoctorDto;
import cn.anei.pethospital.entity.Doctor;
import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamDoctor;
import cn.anei.pethospital.repository.DoctorRepository;
import cn.anei.pethospital.service.DoctorService;
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
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public Doctor existDoctor(Doctor doctor) {
        Doctor d = doctorRepository.findByAccountAndPwd(doctor.getAccount(), doctor.getPwd());
        if (d!=null) {
            d.setPwd(null);
            return d;
        }
        return null;
    }

    @Override
    public Boolean modifyPwd(RePwdParam rePwdParam, Doctor doctor) {
        System.out.println(doctor);
        if (doctor == null)
            return false;

        Doctor d = doctorRepository.findByAccountAndPwd(doctor.getAccount(),rePwdParam.getPwd());
        if (d!=null){
            try{
                d.setPwd(rePwdParam.getNewPwd());
                doctorRepository.save(d);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    public Boolean doctorAdd(Doctor doctor) {
        if (doctorRepository.findByAccount(doctor.getAccount())!=null) {
            return false;
        }else {
            doctor.setPwd(doctor.getPwd());
            doctorRepository.save(doctor);
            return true;
        }
    }


    @Override
    public Boolean doctorDelete(String id) {
        try {
            Doctor doctor = doctorRepository.findById(id);
            doctor.setStatus(1);
            doctorRepository.save(doctor);
        }
        catch (Exception e){
            return true;
        }
        Doctor d = doctorRepository.findByIdAndStatus(id, "0");
        if(d != null){
            return true;
        }else{
            return  false;
        }
    }


    @Override
    public Boolean doctorModify(Doctor doctor) {
        Doctor d = doctorRepository.findOne(doctor.getId());
        if (d!=null){
            d.setName(doctor.getName());
            d.setBirth(doctor.getBirth());
            try{
                doctorRepository.save(d);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> getDoctors(SearchParam searchParam) {
        PageRequest pageRequest = new PageRequest(searchParam.getPage(), searchParam.getSize());
        Page<Doctor> doctors;
        if (searchParam.getParam() != null) {
            doctors = doctorRepository.findAllByNameContaining(searchParam.getParam(), pageRequest);
        } else {
            doctors = doctorRepository.findAll(pageRequest);
        }
        return doctors(doctors);
    }

    @Override
    public Map<String, Object> getDoctorsByCond(SearchParamDoctor searchParamDoctor) {
        PageRequest pageRequest = new PageRequest(searchParamDoctor.getPage(), searchParamDoctor.getSize());
        Doctor cond = searchParamDoctor.getDoctor();
        if(cond != null){
            Specification<Doctor> query = new Specification<Doctor>() {
                @Override
                public Predicate toPredicate(Root<Doctor> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicates = new ArrayList<>();
                    if(!StringUtils.isEmpty(cond.getAccount())){
                        predicates.add(criteriaBuilder.like(root.get("account"), "%" + cond.getAccount() + "%"));
                    }
                    if(!StringUtils.isEmpty(cond.getName())){
                        predicates.add(criteriaBuilder.like(root.get("name"), "%" + cond.getName() + "%"));
                    }
                    if(!StringUtils.isEmpty(cond.getStatus())){
                        predicates.add(criteriaBuilder.equal(root.get("status"), cond.getStatus()));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            };
            Page<Doctor> doctors = doctorRepository.findAll(query,pageRequest);
            return doctors(doctors);
        }
        Page<Doctor> doctors = doctorRepository.findAll(pageRequest);
        return doctors(doctors);
    }

    @Override
    public Doctor getDoctor(String id) {
        Doctor d = doctorRepository.findById(id);
        return d;
    }

    public Map<String, Object> doctors(Page<Doctor> doctors){
        if (doctors != null) {
            Map<String, Object> map = new HashMap<>();
            List<DoctorDto> doctorDtos = new ArrayList<>();
            for (Doctor doctor : doctors) {
                doctorDtos.add(new DoctorDto(doctor));
            }
            map.put("totalElements", doctors.getTotalElements());
            map.put("content", doctorDtos);
            return map;
        }
        return null;
    }

}
