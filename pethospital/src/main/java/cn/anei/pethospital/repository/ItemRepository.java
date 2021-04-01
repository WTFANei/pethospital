package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {

    Item findById(String id);

    Page<Item> findAllByNameLike(String name, Pageable pageable);
}
