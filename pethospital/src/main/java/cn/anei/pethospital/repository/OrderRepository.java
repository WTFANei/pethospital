package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRepository extends JpaRepository<Order, String>, JpaSpecificationExecutor {

    Order findById(String id);

    Order findByIdAndStatus(String id, String status);

    Page<Order> findAllByDidOrderByOtimeDesc(String did, Pageable pageable);

    Page<Order> findAllByDidAndIsfinishOrderByOtimeDesc(String did, Integer isfinish, Pageable pageable);

}
