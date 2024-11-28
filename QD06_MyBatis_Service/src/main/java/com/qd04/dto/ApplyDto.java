package com.qd04.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ApplyDto {

	private int num;
	private String userName;
	private String userPhone;
	private String applyPart;
	private String applyMotive;
	private Timestamp applyTM ;

}
