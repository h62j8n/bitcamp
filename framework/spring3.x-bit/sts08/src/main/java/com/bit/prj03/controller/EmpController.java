package com.bit.prj03.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.bit.prj03.model.entity.EmpVo;
import com.bit.prj03.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	// list
	@RequestMapping("/emp/list")
	public String list(Model model) {
		empService.list(model);
		return "emplist";
	}
	
	// insert
	@RequestMapping(value = "/emp/add", method = RequestMethod.GET)
	public String add() {
		return "empadd";
	}
	@RequestMapping(value = "/emp/add", method = RequestMethod.POST)
	public String add(@ModelAttribute EmpVo bean) {
		empService.insert(bean);
		return "redirect:list";
	}
	
	// detail
	@RequestMapping("/emp/detail/{idx}")	// sabun -> idx
	public String detail(Model model, @PathVariable("idx") int sabun) {
		empService.detail(model, sabun);
		return "empone";
	}
	
	// edit
	@RequestMapping(value = "/emp/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute EmpVo bean) {
		empService.update(bean);
		return "redirect:detail/"+bean.getSabun();
	}
	
	// delete
	@RequestMapping(value = "/emp/delete", method = RequestMethod.POST)
	public String delete(int sabun) {
		empService.delete(sabun);
		return "redirect:list";
	}
}
