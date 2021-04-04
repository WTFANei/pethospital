package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.dto.OrderDto;
import cn.anei.pethospital.entity.Medicine;
import cn.anei.pethospital.entity.Order;
import cn.anei.pethospital.entity.Prescription;
import cn.anei.pethospital.param.OrderCommitParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.param.SearchParamOrder;
import cn.anei.pethospital.repository.CountRepository;
import cn.anei.pethospital.repository.MedicineRepository;
import cn.anei.pethospital.repository.OrderRepository;
import cn.anei.pethospital.repository.PrescriptionRepository;
import cn.anei.pethospital.service.OrderService;
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
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Boolean orderAdd(Order order) {
        if (orderRepository.findById(order.getId())!=null) {
            return false;
        }else {
            orderRepository.save(order);
            return true;
        }
    }

    @Override
    public Boolean orderCommit(OrderCommitParam orderCommitParam) {
        Order order = orderCommitParam.getOrder();
        if(order.getStatus() == 2){
            return false;
        }
        List<Prescription> prescriptionList = orderCommitParam.getPrescriptionList();
        String orderId = order.getId();
        try {
            Date time = new Date();
            order.setFtime(time);
            order.setText(order.getText());
            order.setIsfinish(1);
            orderRepository.save(order);
            if(null != prescriptionList && prescriptionList.size() !=0 ){
                for (int i = 0 ; i < prescriptionList.size() ; i++){
                    Prescription prescription = prescriptionList.get(i);
                    prescription.setOid(orderId);
                    String mid = prescription.getMid();
                    Integer mnum = prescription.getMnum();
                    Medicine medicine = medicineRepository.findById(mid);
                    if(null == medicine){
                        return false;
                    }
                    Integer num = medicine.getNum();
                    Integer remainderNum = num - mnum;
                    if (remainderNum < 0) {
                        return false;
                    }
                    Double medicinePrice = medicine.getPrice();
                    Double cprice = medicinePrice * mnum;
                    prescription.setCpirce(cprice);
                    prescription.setPtime(time);

                    medicine.setNum(remainderNum);
                    medicineRepository.save(medicine);

                    prescriptionRepository.save(prescription);
                }
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }


    @Override
    public Boolean orderDelete(String id) {
        try {
            Order order = orderRepository.findById(id);
            order.setStatus(1);
            orderRepository.save(order);
        }
        catch (Exception e){
            return true;
        }
        return orderRepository.exists(id) ? true : false;
    }


    @Override
    public Boolean orderModify(Order order) {
        Order o = orderRepository.findOne(order.getId());
        if (o!=null){
            o.setStatus(order.getStatus());
            try{
                orderRepository.save(o);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> getOrders(SearchParam searchParam) {
        PageRequest pageRequest = new PageRequest(searchParam.getPage(), searchParam.getSize());
        Page<Order> orders = orderRepository.findAll(pageRequest);
        return orders(orders);
    }

    @Override
    public Map<String, Object> getOrdersByDid(SearchParam searchParam) {
        PageRequest pageRequest = new PageRequest(searchParam.getPage(), searchParam.getSize());
        Page<Order> orders = orderRepository.findAllByDidOrderByOtimeDesc(searchParam.getParam(), pageRequest);
        return orders(orders);
    }

    @Override
    public Map<String, Object> getOrdersByDidPreOrder(SearchParam searchParam) {
        PageRequest pageRequest = new PageRequest(searchParam.getPage(), searchParam.getSize());
        Page<Order> orders = orderRepository.findAllByDidAndIsfinishOrderByOtimeDesc(searchParam.getParam(), 0, pageRequest);
        return orders(orders);
    }

    @Override
    public Map<String, Object> getOrdersByCond(SearchParamOrder searchParamOrder) {
        Sort.Direction sort =  Sort.Direction.DESC;
        PageRequest pageRequest = new PageRequest(searchParamOrder.getPage(), searchParamOrder.getSize(), sort , "otime");
        Order cond = searchParamOrder.getOrder();
        if(cond != null){
            Specification<Order> query = new Specification<Order>() {
                @Override
                public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicates = new ArrayList<>();
                    if(!StringUtils.isEmpty(cond.getUid())){
                        predicates.add(criteriaBuilder.equal(root.get("uid"),cond.getUid()));
                    }
                    if(!StringUtils.isEmpty(cond.getIid())){
                        predicates.add(criteriaBuilder.equal(root.get("iid"),cond.getIid()));
                    }
                    if(!StringUtils.isEmpty(cond.getDid())){
                        predicates.add(criteriaBuilder.equal(root.get("did"),cond.getDid()));
                    }
                    if(!StringUtils.isEmpty(cond.getPid())){
                        predicates.add(criteriaBuilder.equal(root.get("pid"),cond.getPid()));
                    }
                    if(!StringUtils.isEmpty(cond.getIsfinish())){
                        predicates.add(criteriaBuilder.equal(root.get("isfinish"),cond.getIsfinish()));
                    }
                    if(!StringUtils.isEmpty(cond.getStatus())){
                        predicates.add(criteriaBuilder.equal(root.get("status"), cond.getStatus()));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            };
            Page<Order> orders = orderRepository.findAll(query,pageRequest);
            return orders(orders);
        }
        Page<Order> orders = orderRepository.findAll(pageRequest);
        return orders(orders);
    }

    @Override
    public Order getOrder(String id) {
        Order o = orderRepository.findById(id);
        return o;
    }

    public Map<String, Object> orders(Page<Order> orders){
        if (orders != null) {
            Map<String, Object> map = new HashMap<>();
            List<OrderDto> orderDtos = new ArrayList<>();
            for (Order order : orders) {
                orderDtos.add(new OrderDto(order));
            }
            map.put("totalElements", orders.getTotalElements());
            map.put("content", orderDtos);
            return map;
        }
        return null;
    }

}
