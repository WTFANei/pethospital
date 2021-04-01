package cn.anei.pethospital.dto;

import cn.anei.pethospital.entity.Pet;
import lombok.Data;


@Data
public class PetDto {

    private String id;
    private String uid;
    private String name;
    private Integer age;
    private Integer sex;


    public PetDto(Pet pet) {
        this.id = pet.getId();
        this.uid = pet.getUid();
        this.name = pet.getName();
        this.age = pet.getAge();
        this.sex = pet.getSex();
    }
}
