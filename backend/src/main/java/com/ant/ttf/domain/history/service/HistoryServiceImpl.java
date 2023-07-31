package com.ant.ttf.domain.history.service;

import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ant.ttf.domain.history.dto.response.CategoryExpendsDTO;
import com.ant.ttf.domain.history.dto.response.MonthlyPriceDTO;
import com.ant.ttf.domain.history.dto.response.ThreeMonthInfoDTO;
import com.ant.ttf.domain.history.dto.response.TodayStateInfoDTO;
import com.ant.ttf.domain.history.mapper.HistoryMapper;
import com.ant.ttf.domain.users.entity.Users;
import com.ant.ttf.domain.users.mapper.UsersMapper;
import com.ant.ttf.global.jwt.service.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Service
@RequiredArgsConstructor
@Log
public class HistoryServiceImpl implements HistoryService {
	
    private final HistoryMapper historyMapper;
    private final UsersMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;
	
    //카테고리별 지출내역 리스트
	public List<CategoryExpendsDTO> getCateExpendsList(String token){
		String userPk = jwtTokenProvider.getUserPk(token);
		List<CategoryExpendsDTO> cateExpendsList = historyMapper.findCategoryExpend(userPk); // 카테고리 지출 내역 담은 리스트;
		
		return cateExpendsList;
	}
	
	// 사용자 하루 지출 상태 정보
	public TodayStateInfoDTO getTodayState(String token) {
		String userPk = jwtTokenProvider.getUserPk(token);
		Users userDto = userMapper.findUserInfoByPk(userPk);
		TodayStateInfoDTO today = historyMapper.findTodayExpend(userPk);
		
		int goal = userDto.getGoal_budget();
		Calendar cal = new GregorianCalendar();
        int daysOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        int standard = Math.round(goal/daysOfMonth);
        
        if(today.getDayExpend()<= (standard/2)) {
        	today.setDayState("여유");
        } else if(today.getDayExpend()<=standard) {
        	today.setDayState("양호");
        } else {
        	today.setDayState("위험");
        }
		return today;
	}
	public ThreeMonthInfoDTO getThreeMonthInfo(String token) {
		return null;
	}
	
	// 매달 예상 고정 지출
	@Override
	public String fixedPrice(String token) {
		String userPk = jwtTokenProvider.getUserPk(token);
		Users userDto = userMapper.findUserInfoByPk(userPk);
		String fixed = historyMapper.expectMonthlyFixedPrice(userPk);
		return fixed;
	}
	
	// 달별 올해 지출 기록 
	public List<MonthlyPriceDTO> getMonPriceList(String token){
		String userPk = jwtTokenProvider.getUserPk(token);
		List<MonthlyPriceDTO> monPriceList = historyMapper.findMonthlyExpend(userPk);
		return monPriceList;
	}
	
	//Map<String,Object>map = new HashMap<String,Object>();????
}
