package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired  // 의존성주입
    private UserRepository userRepository;

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id){
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            return "삭제에 실패했습니다. 해당 id는 DB에 없습니다.";
        }
        return "삭제되었습니다.id:" + id;
    }



    // save 함수는 id를 전달하지 않으면 insert를 해주고
    // save 함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해준다.
    // email,password
    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){
        // json 데이터를 요청 => java Object(Jackson 라이브러리)로 변환해서 받아줌
        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정에 실패했습니다.");
        });
        user.setPassword((requestUser.getPassword()));
        user.setEmail(requestUser.getEmail());
//        userRepository.save(user);
        // 더티 체킹
        return user;
    }


    @GetMapping("/dummy/users")
    public List<User>list(){
        return userRepository.findAll();
    }
    // 한페이지당 2건에 데이터를 리턴받아 볼 예정
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2,sort = "id",direction = Sort.Direction.DESC)Pageable pageable){
        Page<User> pagingUser = userRepository.findAll(pageable);
        List<User> users = pagingUser.getContent();
        return users;
    }

    // {id} 주소로 파라미터 전달 받을 수 있음
    // http://localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){
        // id 를 못찾으면 null이기 때문에 문제가 발생한다. 고로 예외처리해준다.
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다.id:"+id);
            }
        });
//         요청 : 웹브라우저
//         user 객체 = 자바 오브젝트
//         변환(웹브라우저가 이해할 수 있는 데이터) -> json(Gson 라이브러리)
//         스프링부트 = MessageConverter라는 애가 응답시에 자동 작동
//         만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
//         user 오브젝트를 json으로 변환해서 브라우저에게 던져준다.
        return user;
    }

    @PostMapping("/dummy/join")
    public String join(User user){
        System.out.println("id" + user.getId());
        System.out.println("username" + user.getUsername());
        System.out.println("password" + user.getPassword());
        System.out.println("email" + user.getEmail());
        System.out.println("role" + user.getRole());
        System.out.println("createDate" + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다";
    }




}
