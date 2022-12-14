package com.cos.blog.controller.api;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    @Autowired
    private UserService userService;

    //    @Autowired
//    private HttpSession session;


    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){  // username, password, emaul
        System.out.println("USerApiController: save 호출됨");
        // 실제로 DB에 insert를 하고 아래에서 return이 된다.
        user.setRole(RoleType.USER);
        userService.save(user);
        // result를 받아서 -1이면 실패, 1이면성공
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);  // 자바오브젝트를 json으로 변환해서 리턴
    }

}
