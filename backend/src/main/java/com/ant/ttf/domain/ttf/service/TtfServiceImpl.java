package com.ant.ttf.domain.ttf.service;

import org.springframework.stereotype.Service;

import com.ant.ttf.domain.ttf.dto.request.TtfJoinReqDTO;
import com.ant.ttf.domain.ttf.mapper.TtfMapper;
import com.ant.ttf.domain.users.entity.Users;
import com.ant.ttf.domain.users.mapper.UsersMapper;
import com.ant.ttf.global.jwt.service.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TtfServiceImpl implements TtfService {
	
	
	
	private final JwtTokenProvider jwtTokenProvider;
	private final UsersMapper userMapper;
	private final TtfMapper ttfMapper;
	
	
	@Override
	public void thinJoin(String token, TtfJoinReqDTO dto) throws Exception {
		String userPK = jwtTokenProvider.getUserPk(token);
		Users user = userMapper.findUserInfoByPk(userPK);
		
		
	}
}
