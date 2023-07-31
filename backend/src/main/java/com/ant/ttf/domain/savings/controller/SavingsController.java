package com.ant.ttf.domain.savings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant.ttf.domain.savings.mapper.SavingsMapper;
import com.ant.ttf.domain.savings.service.SavingsService;
import com.ant.ttf.global.ResponseFormat;
import com.ant.ttf.global.ResponseStatus;
import com.ant.ttf.global.jwt.service.JwtTokenProvider;
import java.util.Map;

import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/v1/savings")
@Log
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SavingsController {
	
	@Autowired
	SavingsService savingsService;
	
	@Autowired
	SavingsMapper savingsMapper;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;

//	// 은행 리스트 불러오는 API
//	@GetMapping("/savings/bankInfo")
//	public ResponseEntity<ResponseFormat<List<BankInfoDTO>>> bankinfo() throws Exception{
//		List<BankInfoDTO> bank = savingsService.getBankInfoList();
//		List<Map<String, Object>> bankEle = savingsMapper.findBankInfo();
//		ResponseFormat<List<BankInfoDTO>> responseFormat = new ResponseFormat<>(ResponseStatus.SAVINGS_GET_BANKINFO_SUCCESS, bank);
//		return ResponseEntity.status(HttpStatus.OK).body(responseFormat);
//	}
	
	// 은행 리스트 불러오는 API
	@GetMapping("/bankInfo")
	public ResponseEntity<ResponseFormat<Map<String, Object>>> bankinfo() throws Exception{
		List<Map<String, Object>> bankEle = savingsMapper.findBankInfo();
		ResponseFormat<Map<String, Object>> responseFormat = new ResponseFormat<>(ResponseStatus.SAVINGS_GET_BANKINFO_SUCCESS, bankEle);
		return ResponseEntity.status(HttpStatus.OK).body(responseFormat);
	}
}
