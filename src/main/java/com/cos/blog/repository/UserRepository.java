package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO
// 자동으로 빈 등록이 된다
//@Repository   // 생략 가능하다                       User테이블이 관리하는 repo, primary key는 Integer
public interface UserRepository extends JpaRepository<User,Integer> {

}
