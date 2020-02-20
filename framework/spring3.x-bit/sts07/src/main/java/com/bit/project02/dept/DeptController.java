package com.bit.project02.dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.project02.model.DeptDao;
import com.bit.project02.model.entity.DeptVo;

@Controller
@RequestMapping("/dept/")
public class DeptController {
	DeptDao dao;
	
	@Autowired
	public void setDao(DeptDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("list", dao.selectAll());
		
		return "deptlist";
	}
	
	// 배열을 통해 view를 여러개 받아 add, insert페이지 모두 addForm() 메소드를 진행하게 한다.
	@RequestMapping(value = {"add", "insert"}, method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("title", "INSERT");
		model.addAttribute("btn1", "입력");
		model.addAttribute("action", "insert");
		model.addAttribute("method", "post");
		
		return "deptform";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(Model model, String dname, String loc) {
		// validation
		if (dname.isEmpty()) {
			model.addAttribute("bean", new DeptVo(0, dname, loc));
			model.addAttribute("title", "INSERT");
			model.addAttribute("action", "insert");
			model.addAttribute("method", "post");
			model.addAttribute("btn1", "입력");
			return "deptform";
		}
		
		// insert
		dao.insertOne(dname, loc);
		
		return "redirect:list";
	}
	
	@RequestMapping("detail")
	public String detail(int idx, Model model) {
		model.addAttribute("bean", dao.selectOne(idx));
		model.addAttribute("title", "DETAIL");
		model.addAttribute("action", "edit");
		model.addAttribute("method", "get");
		model.addAttribute("disabled", "disabled");
		model.addAttribute("btn1", "수정하기");
		
		return "deptform";	// 재사용
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(int deptno, Model model) {
		model.addAttribute("bean", dao.selectOne(deptno));
		model.addAttribute("title", "EDIT");
		model.addAttribute("method", "post");
		model.addAttribute("btn1", "수정");
		
		return "deptform";	// 재사용
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(Model model, int deptno, String dname, String loc) {
		if (dname.isEmpty()) {
			model.addAttribute("bean", new DeptVo(deptno, dname, loc));
			model.addAttribute("title", "EDIT");
			model.addAttribute("method", "post");
			model.addAttribute("btn1", "수정");
			
			return "deptform";
		}
		
		if (dao.updateOne(dname, loc, deptno) > 0) { // 결과값
			
			return "redirect:detail?idx=" + deptno;
		}
		
		model.addAttribute("bean", dao.selectOne(deptno));
		
		return "redirect:edit?deptno = " + deptno;
	}
}
