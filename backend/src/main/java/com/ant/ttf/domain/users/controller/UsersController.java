package com.ant.ttf.domain.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ant.ttf.domain.users.dto.request.UsersLoginReqDTO;
import com.ant.ttf.domain.users.dto.request.UsersRequestDTO;
import com.ant.ttf.domain.users.dto.response.UserDashboardInfoDTO;
import com.ant.ttf.domain.users.entity.Users;
import com.ant.ttf.domain.users.service.UsersService;
import com.ant.ttf.global.ResponseFormat;
import com.ant.ttf.global.ResponseStatus;
import com.ant.ttf.global.jwt.service.JwtTokenProvider;

import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/v1/users")
@Log
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class UsersController {
	@Autowired
	UsersService usersService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	
	// 유저 회원가입 API
	@PostMapping("/signup")
	public ResponseEntity<ResponseFormat<String>> createUser(UsersRequestDTO dto) throws Exception{
	
		// 서비스 호출
		
		ResponseFormat<String> responseFormat = new ResponseFormat<>(ResponseStatus.USER_POSTSIGNUP_SUCCESS);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseFormat);
	}
	
	// 유저 로그인 API
    @PostMapping("/login")
    public ResponseEntity<ResponseFormat<String>> login(UsersLoginReqDTO dto) throws Exception{
        String token = usersService.login(dto);
		ResponseFormat<String> responseFormat = new ResponseFormat<>(ResponseStatus.USER_POSTLOGIN_SUCCESS, token);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseFormat);
    }
    
    // 대시보드 상단 유저 정보 가져오는 API
    @GetMapping("/dashboard")
    public ResponseEntity<ResponseFormat<UserDashboardInfoDTO>> userDashboardInfo(@RequestHeader("X-AUTH-TOKEN") String token) throws Exception{
    	UserDashboardInfoDTO userInfo = usersService.userDshInfo(token);
    	ResponseFormat<UserDashboardInfoDTO> responseFormat = new ResponseFormat<>(ResponseStatus.DASHBOARD_GET_USERINFO_SUCCESS, userInfo);
    	return ResponseEntity.status(HttpStatus.OK).body(responseFormat);
    }
    
   
}
