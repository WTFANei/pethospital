package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.dto.ItemDto;
import cn.anei.pethospital.entity.Item;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.repository.ItemRepository;
import cn.anei.pethospital.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Boolean itemAdd(Item item) {
        if (itemRepository.findById(item.getId())!=null) {
            return false;
        }else {
            itemRepository.save(item);
            return true;
        }
    }


    @Override
    public Boolean itemDelete(String id) {
        itemRepository.delete(id);
        return itemRepository.exists(id) ? true : false;
    }


    @Override
    public Boolean itemModify(Item item) {
        Item d = itemRepository.findOne(item.getId());
        if (d!=null){
            d.setName(item.getName());
            d.setText(item.getText());
            try{
                itemRepository.save(d);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> getItems(SearchParam searchParam) {
        PageRequest pageRequest = new PageRequest(searchParam.getPage(), searchParam.getSize());
        Page<Item> items;
        if (searchParam.getParam() != null) {
            items = itemRepository.findAllByNameLike("%" + searchParam.getParam() + "%", pageRequest);
        } else {
            items = itemRepository.findAll(pageRequest);
        }
        return items(items);
    }

    @Override
    public Item getItem(Item item) {
        Item d = itemRepository.findById(item.getId());
        return d;
    }

    public Map<String, Object> items(Page<Item> items){
        if (items != null) {
            Map<String, Object> map = new HashMap<>();
            List<ItemDto> itemDtos = new ArrayList<>();
            for (Item item : items) {
                itemDtos.add(new ItemDto(item));
            }
            map.put("totalElements", items.getTotalElements());
            map.put("content", itemDtos);
            return map;
        }
        return null;
    }

}
