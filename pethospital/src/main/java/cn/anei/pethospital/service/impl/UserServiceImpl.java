package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.dto.UserDto;
import cn.anei.pethospital.entity.User;
import cn.anei.pethospital.param.SearchParamUser;
import cn.anei.pethospital.repository.UserRepository;
import cn.anei.pethospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User existUser(User user) {
        User u = userRepository.findByPhoneAndPwd(user.getPhone(), user.getPwd());
        if (u!=null) {
            u.setPwd(null);
            return u;
        }
        return null;
    }

    @Override
    public Boolean register(User user) {
        if (userRepository.findByPhone(user.getPhone())!=null) {
            return false;
        }else {
            user.setPwd(user.getPwd());
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public Map<String, Object> getUsers(SearchParam searchParam) {
        PageRequest pageRequest = new PageRequest(searchParam.getPage(), searchParam.getSize());
        Page<User> users;
        if (searchParam.getParam() != null) {
            users = userRepository.findAllByPhoneContaining(searchParam.getParam(), pageRequest);
        } else {
            users = userRepository.findAll(pageRequest);
        }
        return users(users);
    }

    @Override
    public Map<String, Object> getUsersByCond(SearchParamUser searchParamUser) {
        PageRequest pageRequest = new PageRequest(searchParamUser.getPage(), searchParamUser.getSize());
        User cond = searchParamUser.getUser();
        if(cond != null){
            Specification<User> query = new Specification<User>() {
                @Override
                public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicates = new ArrayList<>();
                    if(!StringUtils.isEmpty(cond.getName())){
                        predicates.add(criteriaBuilder.like(root.get("name"), "%" + cond.getName() + "%"));
                    }
                    if(!StringUtils.isEmpty(cond.getPhone())){
                        predicates.add(criteriaBuilder.like(root.get("phone"), "%" + cond.getPhone() + "%"));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            };
            Page<User> users = userRepository.findAll(query,pageRequest);
            return users(users);
        }
        Page<User> users = userRepository.findAll(pageRequest);
        return users(users);
    }

    public Map<String, Object> users(Page<User> users){
        if (users != null) {
            Map<String, Object> map = new HashMap<>();
            List<UserDto> userDtos = new ArrayList<>();
            for (User user : users) {
                userDtos.add(new UserDto(user));
            }
            map.put("totalElements", users.getTotalElements());
            map.put("content", userDtos);
            return map;
        }
        return null;
    }

    @Override
    public User getUser(User user) {
        User u = userRepository.findById(user.getId());
        return u;
    }


    @Override
    public Boolean modifyPwd(RePwdParam rePwdParam, User user) {
        if (user == null)
            return false;
        User u = userRepository.findByPhoneAndPwd(user.getPhone(),rePwdParam.getPwd());
        if (u!=null){
            u.setPwd(rePwdParam.getNewPwd());
            try{
                userRepository.save(u);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    public Boolean userDelete(String id) {
        try {
            userRepository.delete(id);
        }
        catch (Exception e){
            return true;
        }
        return userRepository.exists(id) ? true : false;
    }

    @Override
    public Boolean userModify(User user) {
        User u = userRepository.findOne(user.getId());
        if (u!=null){
            u.setName(user.getName());
            try{
                userRepository.save(u);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

}
