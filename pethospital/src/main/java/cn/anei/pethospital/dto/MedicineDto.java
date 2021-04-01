package cn.anei.pethospital.dto;

import cn.anei.pethospital.entity.Medicine;
import lombok.Data;


@Data
public class MedicineDto {

    private String id;
    private String name;
    private String text;
    private Integer num;
    private Double price;


    public MedicineDto(Medicine midicine) {
        this.id = midicine.getId();
        this.name = midicine.getName();
        this.text = midicine.getText();
        this.num = midicine.getNum();
        this.price = midicine.getPrice();
    }
}
