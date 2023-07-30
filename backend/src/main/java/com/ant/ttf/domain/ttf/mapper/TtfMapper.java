package com.ant.ttf.domain.ttf.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ant.ttf.domain.ttf.entity.Ttf;

@Mapper
public interface TtfMapper {
	
	String findAccountNum(Long accountId); //계좌번호 조회
	int regTtf(Ttf ttf); // 신파일러 적금가입
	
	int seeLimit(String userPK); //신파일러 적금계좌 한도조회
	
	int balUpdate(Map map); // 신파일러 결제
}
