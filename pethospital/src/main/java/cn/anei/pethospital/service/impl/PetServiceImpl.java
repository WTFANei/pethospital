package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.dto.PetDto;
import cn.anei.pethospital.entity.Pet;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.repository.PetRepository;
import cn.anei.pethospital.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
        petRepository.delete(id);
        return petRepository.exists(id) ? true : false;
    }


    @Override
    public Boolean petModify(Pet pet) {
        Pet d = petRepository.findOne(pet.getId());
        if (d!=null){
            d.setName(pet.getName());
            d.setAge(pet.getAge());
            d.setSex(pet.getSex());
            try{
                petRepository.save(d);
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
            pets = petRepository.findAllByUid(searchParam.getParam(), pageRequest);
        } else {
            pets = petRepository.findAll(pageRequest);
        }
        return pets(pets);
    }

    @Override
    public Pet getPet(Pet pet) {
        Pet d = petRepository.findById(pet.getId());
        return d;
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
