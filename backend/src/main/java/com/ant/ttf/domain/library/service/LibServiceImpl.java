package com.ant.ttf.domain.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ant.ttf.domain.library.dto.response.LibTotalResDTO;
import com.ant.ttf.domain.library.entity.Account;
import com.ant.ttf.domain.library.mapper.LibMapper;
import com.ant.ttf.domain.ttf.mapper.TtfMapper;
import com.ant.ttf.global.jwt.service.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LibServiceImpl implements LibService {
	
	private final JwtTokenProvider jwtTokenProvider;
	private final LibMapper libMapper;
	private final TtfMapper ttfMapper;
	
	public List<LibTotalResDTO> seeTotalAcc(String token) throws Exception {
		//1. userPK 조회하여 account 정보 들고오기 -> LibTotalResDTO에 담아주기 (빌더이용?)
		//2. 위로부터 들고온 account 정보에서 bank_id 뽑아와서 이거 가지고 bankinfo테이블에서 name과 img_url 뽑아오기 -> LibTotalResDTO에 담아주기
		//3. LibTotalResDTO를 list에 담아준다 
		//4. list 출력
		//5. for문을 이용하여 1~4 반복 후, 리턴
		
		List<LibTotalResDTO> dtoList = new ArrayList<>();
		String userPK = jwtTokenProvider.getUserPk(token);
		List<Account> list = new ArrayList<>();

		list = libMapper.listAcc(userPK); // 특정 유저에 속한 모든 계좌를 list로 받는다.
		
		for(Account userAcc : list) {
			
			LibTotalResDTO dto = new LibTotalResDTO();
			
			//빌더이용해서 dto에 필요한 정보 넣기(from account 테이블)
			dto = userAcc.convertDTO(userAcc);
			
			//bankinfo 테이블에서 은행이름과 이미지url 정보출력
			String bankName = libMapper.nameImg(userAcc.getBank_info()).getName();
			String urlinfo = libMapper.nameImg(userAcc.getBank_info()).getImg_url();
			dto.setName(bankName); //dto에 은행이름 넣기
			dto.setImg_url(urlinfo); // dto에 은행uri 넣기
			
			if(userAcc.getAcc_ck() == 0) { 
				// 입출금계좌이면 dto의 monthBalance(한달사용지출액) = 유저의 월예산(유저테이블) - 통장잔고 (account테이블)
				int monthIn = libMapper.monthIncome(userPK);
				dto.setMonthBalance(monthIn - userAcc.getBalance()); // dto에 한달사용지출액 넣기
				
			} else if(userAcc.getAcc_ck() == 1) { //적금계좌일때
				dto.setMonthBalance(0);
			} else { // 신파일러 출금계좌일때, 한달사용금액 = balance - limitAmount
				int Bala = ttfMapper.seeBalance(userAcc.getAccount_id());
				int limitAmo = ttfMapper.seeLimitAmount(userAcc.getAccount_id());
				dto.setMonthBalance(Bala - limitAmo);	
			}
			
			dtoList.add(dto);	
		}
		return dtoList;
		
	}
}
