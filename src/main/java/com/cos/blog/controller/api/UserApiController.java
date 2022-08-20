package com.cos.blog.controller.api;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;



    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){  // username, password, emaul
        System.out.println("USerApiController: save 호출됨");
        // 실제로 DB에 insert를 하고 아래에서 return이 된다.
        user.setRole(RoleType.USER);
        userService.save(user);
        // result를 받아서 -1이면 실패, 1이면성공
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);  // 자바오브젝트를 json으로 변환해서 리턴
    }

    @PostMapping("/api/user/login")
    public ResponseDto<Integer>login(@RequestBody User user, HttpSession session){
        System.out.println("UserApiController:login호출됨");
        User principal = userService.login(user);  //principal(접근주체)
        if(principal!=null){
            // 세션을 만들어 로그인 후에 홈페이지 가도 로그인 유지
            session.setAttribute("principal",principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
}
