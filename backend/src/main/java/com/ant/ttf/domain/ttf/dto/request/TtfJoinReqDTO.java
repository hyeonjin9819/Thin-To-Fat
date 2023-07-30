package com.ant.ttf.domain.ttf.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TtfJoinReqDTO {
	private long account_id;
	private int joinPeriod;
	private int cans;
}
