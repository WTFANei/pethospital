package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, String> {

    Medicine findById(String id);

    Page<Medicine> findAllByNameLike(String name, Pageable pageable);
}
