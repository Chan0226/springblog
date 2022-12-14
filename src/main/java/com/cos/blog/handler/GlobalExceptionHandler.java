package com.cos.blog.handler;

import com.cos.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice   // 어떤 파일에서든 Exception이 발생하면 함수 실행하도록 설정
@RestController
public class GlobalExceptionHandler {
    // IllegalArgumentException이 발생하면 return 반환
    @ExceptionHandler(value = Exception.class)
    public ResponseDto<String>handleArgumentException(Exception e){
        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
