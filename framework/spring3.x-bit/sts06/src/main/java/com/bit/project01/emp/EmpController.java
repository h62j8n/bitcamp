package com.bit.project01.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/emp/")
public class EmpController {
	Emp01Dao emp01Dao;
	
	@Autowired
	public void setEmp01Dao(Emp01Dao emp01Dao) {
		this.emp01Dao = emp01Dao;
	}
	
	// 목록 페이지
	@RequestMapping("list")
	public void list(Model model) {
		model.addAttribute("list", emp01Dao.selectAll());
	}
	
	// 입력 페이지1
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {}
	
	// 입력 페이지2
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(String name, int pay) {
		emp01Dao.insertOne(name, pay);
		return "redirect:list";
	}
	
	// 상세 페이지
	@RequestMapping("detail")
	public void detail(int sabun, Model model) {
		model.addAttribute("bean", emp01Dao.selectOne(sabun));
	}
	
	// 수정 페이지
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public void edit(@RequestParam("idx") int sabun, Model model) {
		model.addAttribute("bean", emp01Dao.selectOne(sabun));
	}
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(int sabun, String name, int pay) {
		emp01Dao.updateOne(sabun, name, pay);
		return "detail?sabun=" + sabun;
	}
	
	// 삭제 페이지
	@RequestMapping("delete")
	public String delete(@RequestParam("idx") int sabun) {
		emp01Dao.deleteOne(sabun);
		return "redirect:list";
	}
}
