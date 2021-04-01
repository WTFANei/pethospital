package cn.anei.pethospital.service.impl;

import cn.anei.pethospital.param.RePwdParam;
import cn.anei.pethospital.param.SearchParam;
import cn.anei.pethospital.util.MD5Util;
import cn.anei.pethospital.dto.UserDto;
import cn.anei.pethospital.entity.User;
import cn.anei.pethospital.repository.UserRepository;
import cn.anei.pethospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ANei
 * @Date: 下午2:22 18/2/20
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User existUser(User user) {
        User u = userRepository.findByNameAndPwd(user.getName(), MD5Util.md5(user.getPwd()));
        if (u!=null) {
            u.setPwd(null);
            u.setComicsUsers(null);
            return u;
        }
        return null;
    }

    @Override
    public Boolean register(User user) {
        if (userRepository.findByName(user.getName())!=null) {
            return false;
        }else {
            user.setPwd(MD5Util.md5(user.getPwd()));
            user.setType(1);
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public Boolean updateInfo(User user) {
        User u = userRepository.findOne(user.getUid());
        if (u!=null){
            u.setSex(user.getSex());
            u.setBirth(user.getBirth());
            u.setEmail(user.getEmail());
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
    public Boolean becomeAuthor(User user) {
        User u = userRepository.findByUid(user.getUid());
        if (u!=null) {
            u.setType(2);
            u.setBirth(user.getBirth());
            u.setRealName(user.getRealName());
            u.setCardNum(user.getCardNum());
            u.setCardPic(user.getCardPic());
            u.setSex(user.getSex());

            userRepository.save(u);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Map<String, Object> getUsers(SearchParam searchParam) {
        PageRequest pageRequest = new PageRequest(searchParam.getPage(), searchParam.getSize());
        Page<User> users;
        if (searchParam.getParam() != null) {
            users = userRepository.findAllByNameLike("%" + searchParam.getParam() + "%", pageRequest);
        } else {
            users = userRepository.findAll(pageRequest);
        }
        return users(users);
    }

    @Override
    public User getUser(User user) {
        User u = userRepository.findByUid(user.getUid());
        return u;
    }

    @Override
    public Map<String, Object> getCheckUsers(SearchParam searchParam) {
        PageRequest pageRequest = new PageRequest(searchParam.getPage(), searchParam.getSize());
        Page<User> users = userRepository.findAllByType(2,pageRequest);
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
    public Boolean removeUserByuid(String uid) {
        userRepository.delete(uid);
        return userRepository.exists(uid) ? true : false;
    }

    @Override
    public Boolean modifyPwd(RePwdParam rePwdParam, User user) {
        if (user == null)
            return false;
        User u = userRepository.findByNameAndPwd(user.getName(),MD5Util.md5(rePwdParam.getUserPwd()));
        if (u!=null){
            u.setPwd(MD5Util.md5(rePwdParam.getNewPwd()));
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
    public Boolean accessUserByuid(String uid) {
        User user = userRepository.findOne(uid);
        if (user!=null){
            user.setType(3);
            userRepository.save(user);
            return true;
        }
        return null;
    }

    @Override
    public Boolean notAccessUserByuid(String uid) {
        User user = userRepository.findOne(uid);
        if (user!=null){
            user.setCardNum(null);
            user.setCardPic(null);
            user.setType(1);
            userRepository.save(user);
            return true;
        }
        return null;
    }

}
