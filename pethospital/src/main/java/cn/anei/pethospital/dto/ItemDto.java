package cn.anei.pethospital.dto;

import cn.anei.pethospital.entity.Item;
import lombok.Data;


@Data
public class ItemDto {

    private String id;
    private String name;
    private String text;


    public ItemDto(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.text = item.getText();
    }
}
