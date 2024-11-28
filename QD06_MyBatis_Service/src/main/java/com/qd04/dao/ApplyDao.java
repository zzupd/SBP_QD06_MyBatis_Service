package com.qd04.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.qd04.dto.ApplyDto;

@Mapper
public interface ApplyDao {
		
	// 지원서 등록
	public void mtdRegProc(Map<String, String> map);
	
	// 지원 정보 리스트
	public List<ApplyDto> mtdList();

	// 리스트 내용 상세보기(= 뷰 보기)
	public ApplyDto mtdView(String numParam);

	// 수정 실행
	public void mtdModProc(Map<String, String> map);

}
