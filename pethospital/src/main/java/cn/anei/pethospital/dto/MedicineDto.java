package cn.anei.pethospital.dto;

import cn.anei.pethospital.entity.Item;
import lombok.Data;


@Data
public class MedicineDto {

    private String id;
    private String name;
    private String text;
    private Integer num;
    private Double price;


    public MedicineDto(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.text = item.getText();
        this.num = item.getNum();
        this.price = item.getPrice();
    }
}
