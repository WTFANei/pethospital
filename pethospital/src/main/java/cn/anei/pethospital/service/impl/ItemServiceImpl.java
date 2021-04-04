package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.dto.ItemDto;
import cn.anei.pethospital.entity.Item;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamItem;
import cn.anei.pethospital.repository.ItemRepository;
import cn.anei.pethospital.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        try {
            Item item = itemRepository.findById(id);
            item.setStatus(1);
            itemRepository.save(item);
        }
        catch (Exception e){
            return true;
        }
        return itemRepository.exists(id) ? true : false;
    }


    @Override
    public Boolean itemModify(Item item) {
        Item i = itemRepository.findOne(item.getId());
        if (i!=null){
            i.setName(item.getName());
            i.setText(item.getText());
            try{
                itemRepository.save(i);
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
            items = itemRepository.findAllByNameContaining(searchParam.getParam(), pageRequest);
        } else {
            items = itemRepository.findAll(pageRequest);
        }
        return items(items);
    }

    @Override
    public Map<String, Object> getItemsByCond(SearchParamItem searchParamItem) {
        PageRequest pageRequest = new PageRequest(searchParamItem.getPage(), searchParamItem.getSize());
        Item cond = searchParamItem.getItem();
        if(cond != null){
            Specification<Item> query = new Specification<Item>() {
                @Override
                public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicates = new ArrayList<>();
                    if(!StringUtils.isEmpty(cond.getName())){
                        predicates.add(criteriaBuilder.like(root.get("name"), "%" + cond.getName() + "%"));
                    }
                    if(!StringUtils.isEmpty(cond.getText())){
                        predicates.add(criteriaBuilder.like(root.get("text"), "%" + cond.getText() + "%"));
                    }
                    if(!StringUtils.isEmpty(cond.getStatus())){
                        predicates.add(criteriaBuilder.equal(root.get("status"), cond.getStatus()));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            };
            Page<Item> items = itemRepository.findAll(query,pageRequest);
            return items(items);
        }
        Page<Item> items = itemRepository.findAll(pageRequest);
        return items(items);
    }


    @Override
    public Item getItem(Item item) {
        Item i = itemRepository.findById(item.getId());
        return i;
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
