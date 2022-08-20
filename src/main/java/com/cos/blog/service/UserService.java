package com.cos.blog.service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IOC를 해준다
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    // 회원가입
    @Transactional    // 트랜잭션 만들기
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true) // select할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료 (정합성)
    public User login(User user){
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
