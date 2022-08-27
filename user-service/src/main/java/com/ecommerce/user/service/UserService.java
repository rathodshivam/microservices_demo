package com.ecommerce.user.service;

import com.ecommerce.user.VO.Department;
import com.ecommerce.user.VO.UserBean;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    UserRepository userRepository;

    RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserServiceImpl");
        return userRepository.save(user);
    }

    public UserBean findUserById(Long userId) {
        UserBean userBean = new UserBean();
        User user = userRepository.findUserByUserId(userId);
        BeanUtils.copyProperties(user, userBean);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        userBean.setDepartment(department);
        return userBean;
    }
}
