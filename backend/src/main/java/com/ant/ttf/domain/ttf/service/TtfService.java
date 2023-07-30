package com.ant.ttf.domain.ttf.service;

import org.springframework.stereotype.Service;

import com.ant.ttf.domain.ttf.dto.request.TtfJoinReqDTO;

@Service
public interface TtfService {
	public void thinJoin(String token, TtfJoinReqDTO dto) throws Exception;
}
