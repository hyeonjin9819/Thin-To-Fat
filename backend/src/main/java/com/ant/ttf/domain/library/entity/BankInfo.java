package com.ant.ttf.domain.library.entity;

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
public class BankInfo {
	
	private Long bank_id;
	private String name;
	private String img_url;
	private int bank_class;
	
}
