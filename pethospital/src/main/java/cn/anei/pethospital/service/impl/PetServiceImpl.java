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
        try {
            petRepository.delete(id);
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
    public Pet getPet(Pet pet) {
        Pet p = petRepository.findById(pet.getId());
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
