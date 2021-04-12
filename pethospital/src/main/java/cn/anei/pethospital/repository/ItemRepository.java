package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ItemRepository extends JpaRepository<Item, String>, JpaSpecificationExecutor {

    Item findById(String id);

    Item findByIdAndStatus(String id, String status);

    Page<Item> findAllByNameContaining(String name, Pageable pageable);
}
