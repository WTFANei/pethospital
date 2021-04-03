package cn.anei.pethospital.param;

import cn.anei.pethospital.entity.Pet;
import lombok.Data;


@Data
public class SearchParamPet extends SearchParam{
    Pet pet;
}
