package com.bit.prj04.model.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor	// 기본생성자
@AllArgsConstructor	// 필드생성자
public class EmpVo {
	int sabun;
	String name;
	Date nalja;
	int pay;
	int deptno;
}
