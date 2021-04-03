package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminRepository extends JpaRepository<Admin, String>, JpaSpecificationExecutor {
    Admin findByAccountAndPwd(String account,String pwd);
}
