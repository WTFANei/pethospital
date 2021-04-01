package cn.anei.pethospital.repository;

import cn.anei.pethospital.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByNameAndPwd(String name,String pwd);

    User findByName(String name);

    Page<User> findAllByNameLike(String name, Pageable pageable);

    Page<User> findAllByType(Integer type, Pageable pageable);

    User findByUid(String uid);
}
