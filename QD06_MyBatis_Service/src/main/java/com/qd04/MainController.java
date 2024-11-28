package com.qd04;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qd04.dao.ApplyDao;
import com.qd04.dto.ApplyDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	@Autowired
	private ApplyDao applyDao;

	
	@GetMapping("/")
	@ResponseBody
	public String root() throws Exception {
		return "개발자 지원서 작업";
	}

	// 지원서 입력양식
	@GetMapping("/applyForm")
	public String applyForm() {
		return "applyForm";
	}
	
	
	
	// 지원서 DB 입력처리
	@GetMapping("/applyProc")
	public String applyProc(
			@RequestParam(value="userName") String userName,
			@RequestParam(value="userPhone") String userPhone,
			@RequestParam(value="applyPart") String applyPart,
			@RequestParam(value="applyMotive") String applyMotive,
			RedirectAttributes redAttr
			) {
		
		Map<String, String> map = new HashMap<>();
		map.put("userName", userName);
		map.put("userPhone", userPhone);
		map.put("applyPart", applyPart);
		map.put("applyMotive", applyMotive);
		
		applyDao.mtdRegProc(map);
		
		redAttr.addAttribute("userName", userName);
		redAttr.addAttribute("userPhone", userPhone);
		redAttr.addAttribute("applyPart", applyPart);
		redAttr.addAttribute("applyMotive", applyMotive);
		
		return "redirect:/list";
	}
	
	
	// 목록출력
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("mtdList", applyDao.mtdList());
		return "list";
	}
	
	
	// 리스트 내용 상세보기(= 뷰 보기)
	@RequestMapping("/view")
	public String result(
			@RequestParam("numParam") String numParam,
			Model model
			) {

		ApplyDto applyDto = applyDao.mtdView(numParam);
		
		model.addAttribute("applyDto", applyDto);
		
		return "view";
	}
	
	
	// 수정 입력 폼 시작
	@GetMapping("/modForm")
	public String mtdMod(HttpServletRequest req, Model model) {
		
		try {
			req.setCharacterEncoding("UTF-8");
			String num = req.getParameter("numParam");
			ApplyDto applyDto = applyDao.mtdView(num);
			model.addAttribute("applyDto", applyDto);
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnEnc : " + e.getMessage());
		}
		
		return "/modForm";
	}
		
	// 수정 실행 시작 
	@GetMapping("/modProc")
	public String mtdModProc(
			@RequestParam(value="numParam") String numParam,
			@RequestParam(value="userPhone") String userPhone,
			@RequestParam(value="applyPart") String applyPart,
			@RequestParam(value="applyMotive") String applyMotive,
			RedirectAttributes redAttr
			) {
		
		Map<String, String> map = new HashMap<>();
		map.put("numParam", numParam);
		map.put("userPhone", userPhone);
		map.put("applyPart", applyPart);
		map.put("applyMotive", applyMotive);
		
		applyDao.mtdModProc(map);
		
		redAttr.addAttribute("numParam", numParam);
		
		return "redirect:/view";
	}


}
