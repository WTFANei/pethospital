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
    private Integer status;


    public MedicineDto(Medicine medicine) {
        this.id = medicine.getId();
        this.name = medicine.getName();
        this.text = medicine.getText();
        this.num = medicine.getNum();
        this.price = medicine.getPrice();
        this.status = medicine.getStatus();
    }
}
