package cn.anei.pethospital.service;

import cn.anei.pethospital.entity.Pet;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamPet;

import java.util.Map;

public interface PetService {

    Boolean petAdd(Pet pet);

    Boolean petDelete(String id);

    Boolean petModify(Pet pet);

    Map<String, Object> getPets(SearchParam searchParam);

    Map<String, Object> getPetsByCond(SearchParamPet searchParamPet);

    Pet getPet(String id);

}
