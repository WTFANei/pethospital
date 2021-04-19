package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PetRepository extends JpaRepository<Pet, String>, JpaSpecificationExecutor {

    Pet findById(String id);

    Pet findByIdAndStatus(String id, Integer status);

    Page<Pet> findAllByNameContaining(String name, Pageable pageable);
}
