package com.ant.ttf.domain.ttf.entity;

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
public class Ttf {
	private Long ttf_id;
	private Long user_id;
	private Long account_id;

	private String start_date;
	private String end_date;
	private int acc_ck;
	private int balance;
	private int limitAmount;
	private String account_num;
	private String qrImage;
	private int bnpl;
	private int cans;
}
