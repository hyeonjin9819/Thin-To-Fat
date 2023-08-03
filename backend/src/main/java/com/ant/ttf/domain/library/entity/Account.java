package com.ant.ttf.domain.library.entity;

import java.time.LocalDateTime;

import com.ant.ttf.domain.library.dto.response.LibTotalResDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	private Long account_id; 
	private Long user_id;
	private Long bank_info;
	private String nickname;
	private String type; 
	private LocalDateTime created_at;
	private String acc_num; 
	private int balance;
	private int acc_ck;
	
	public LibTotalResDTO convertDTO(Account userAcc) {
		
		return LibTotalResDTO.builder()
				.acc_num(userAcc.getAcc_num())
				.type(userAcc.getType())
				.acc_ck(userAcc.getAcc_ck())
				.nickname(userAcc.getNickname())
				.balance(userAcc.getBalance())
				.build();			
	}
	
}
