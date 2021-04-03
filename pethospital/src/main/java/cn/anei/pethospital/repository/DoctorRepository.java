package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DoctorRepository extends JpaRepository<Doctor, String>, JpaSpecificationExecutor {
    Doctor findByAccountAndPwd(String id, String pwd);

    Doctor findById(String id);

    Page<Doctor> findAllByNameContaining(String name, Pageable pageable);
}
