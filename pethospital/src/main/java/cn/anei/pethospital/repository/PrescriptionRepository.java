package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrescriptionRepository extends JpaRepository<Prescription, String>, JpaSpecificationExecutor {

    Prescription findById(String id);

    Prescription findByIdAndStatus(String id, String status);
}
