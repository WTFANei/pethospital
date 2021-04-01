package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Admin findByAccountAndPwd(String account,String pwd);
}
