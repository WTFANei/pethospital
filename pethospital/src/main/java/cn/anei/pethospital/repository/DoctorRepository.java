package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
    Doctor findByAccountAndPwd(String id, String pwd);

    Doctor findById(String id);

    Page<Doctor> findAllByNameContaining(String name, Pageable pageable);
}
