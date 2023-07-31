package com.ant.ttf.domain.Savings.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankInfoDTO {
	private Long bankPk;
	private String name;
	private String imgUrl;
	private int bankClass;
}
