package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.dto.PetDto;
import cn.anei.pethospital.entity.Pet;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamPet;
import cn.anei.pethospital.repository.PetRepository;
import cn.anei.pethospital.service.PetService;
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
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public Boolean petAdd(Pet pet) {
        if (petRepository.findById(pet.getId())!=null) {
            return false;
        }else {
            petRepository.save(pet);
            return true;
        }
    }


    @Override
    public Boolean petDelete(String id) {
        try {
            Pet pet = petRepository.findById(id);
            pet.setStatus(1);
            petRepository.save(pet);
        }
        catch (Exception e){
            return true;
        }
        return petRepository.exists(id) ? true : false;
    }


    @Override
    public Boolean petModify(Pet pet) {
        Pet p = petRepository.findOne(pet.getId());
        if (p!=null){
            p.setName(pet.getName());
            p.setAge(pet.getAge());
            p.setSex(pet.getSex());
            try{
                petRepository.save(p);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> getPets(SearchParam searchParam) {
        PageRequest pageRequest = new PageRequest(searchParam.getPage(), searchParam.getSize());
        Page<Pet> pets;
        if (searchParam.getParam() != null) {
            pets = petRepository.findAllByNameContaining(searchParam.getParam(), pageRequest);
        } else {
            pets = petRepository.findAll(pageRequest);
        }
        return pets(pets);
    }

    @Override
    public Map<String, Object> getPetsByCond(SearchParamPet searchParamPet) {
        PageRequest pageRequest = new PageRequest(searchParamPet.getPage(), searchParamPet.getSize());
        Pet cond = searchParamPet.getPet();
        if(cond != null){
            Specification<Pet> query = new Specification<Pet>() {
                @Override
                public Predicate toPredicate(Root<Pet> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicates = new ArrayList<>();
                    if(!StringUtils.isEmpty(cond.getName())){
                        predicates.add(criteriaBuilder.like(root.get("name"), "%" + cond.getName() + "%"));
                    }
                    if(!StringUtils.isEmpty(cond.getAge())){
                        predicates.add(criteriaBuilder.equal(root.get("age"), cond.getAge()));
                    }
                    if(!StringUtils.isEmpty(cond.getSex())){
                        predicates.add(criteriaBuilder.equal(root.get("sex"), cond.getSex()));
                    }
                    if(!StringUtils.isEmpty(cond.getStatus())){
                        predicates.add(criteriaBuilder.equal(root.get("status"), cond.getStatus()));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            };
            Page<Pet> pets = petRepository.findAll(query,pageRequest);
            return pets(pets);
        }
        Page<Pet> pets = petRepository.findAll(pageRequest);
        return pets(pets);
    }

    @Override
    public Pet getPet(String id) {
        Pet p = petRepository.findById(id);
        return p;
    }

    public Map<String, Object> pets(Page<Pet> pets){
        if (pets != null) {
            Map<String, Object> map = new HashMap<>();
            List<PetDto> petDtos = new ArrayList<>();
            for (Pet pet : pets) {
                petDtos.add(new PetDto(pet));
            }
            map.put("totalElements", pets.getTotalElements());
            map.put("content", petDtos);
            return map;
        }
        return null;
    }

}
