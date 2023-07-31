package com.ant.ttf.domain.Savings.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant.ttf.domain.Savings.dto.response.BankInfoDTO;
import com.ant.ttf.global.ResponseFormat;

import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/v1/savings")
@Log
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SavingsController {

	// 은행 리스트 불러오는 API
//	@GetMapping("/savings/bankInfo")
//	public ResponseEntity<ResponseFormat<List<BankInfoDTO>>> bankinfo (@RequestHeader("X-AUTH-TOKEN") String token) throws Exception{
//		
//	}
}
