package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, String> {

    Pet findById(String id);

    Page<Pet> findAllByNameContaining(String name, Pageable pageable);
}
