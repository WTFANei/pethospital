package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor {
    User findByPhoneAndPwd(String phone,String pwd);

    User findByPhone(String phone);

    Page<User> findAllByPhoneContaining(String phone, Pageable pageable);

    User findById(String id);
}
