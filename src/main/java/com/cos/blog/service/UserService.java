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
    public int save(User user){
        try {
            userRepository.save(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("UserService: 회원가입():"+e.getMessage());
        }
        return -1;
    }
}
