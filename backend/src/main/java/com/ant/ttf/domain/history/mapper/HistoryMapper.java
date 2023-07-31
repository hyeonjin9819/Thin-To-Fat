package com.ant.ttf.domain.history.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ant.ttf.domain.history.dto.response.CategoryExpendsDTO;
import com.ant.ttf.domain.history.dto.response.MonthlyPriceDTO;
import com.ant.ttf.domain.history.dto.response.TodayStateInfoDTO;

@Mapper
public interface HistoryMapper {
	List<CategoryExpendsDTO> findCategoryExpend(String userPk);
	TodayStateInfoDTO findTodayExpend(String userPk);
	String expectMonthlyFixedPrice(String userPk);
	List<MonthlyPriceDTO> findMonthlyExpend(String userPk);
}
