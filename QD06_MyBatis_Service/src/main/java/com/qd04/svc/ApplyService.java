package com.qd04.svc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qd04.dao.ApplyDao;
import com.qd04.dto.ApplyDto;

@Service
public class ApplyService {
	

	@Autowired
	private ApplyDao applyDao;
	
	// 지원서 DB 입력처리(지원서 등록)
	public void mtdRegProc(Map<String, String> map) {
		applyDao.mtdRegProc(map);
	}

	// 목록출력
	public List<ApplyDto> mtdList(){
		return applyDao.mtdList();
	}
	
	// 리스트 내용 상세보기(= 뷰 보기)
	// + 수정 입력 폼 시작
	public ApplyDto mtdView(String numParam) {
		return applyDao.mtdView(numParam);
	}
	
	// 수정 실행 시작 
	public void mtdModProc(Map<String, String> map) {
		applyDao.mtdModProc(map);
	}
	
	
	
	
}
