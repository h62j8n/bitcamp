package com.bit.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.rest.model.entity.EmpVo;
import com.bit.rest.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpRestController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EmpService service;
	
//	@RequestMapping(value="/", method=RequestMethod.POST)
	@PostMapping("/")
	public String insert(@ModelAttribute EmpVo bean) {
		service.insert(bean);
		return "success";
	}
	
	/*
	@GetMapping("/")
	public ResponseEntity test() {
		return ResponseEntity.ok().build();
	}
	*/

//	@RequestMapping(value="/{sabun}", method=RequestMethod.GET)
	@GetMapping("/{sabun}")
	public EmpVo detail(@PathVariable int sabun) {
		EmpVo bean=service.detail(sabun);
		return bean;
	}
	
//	@RequestMapping(value = "/{sabun}", method = RequestMethod.PUT)
	@PutMapping("/{sabun}")
	public String update(@PathVariable int sabun, @RequestBody EmpVo bean) {
		log.debug(bean.toString());
		service.update(bean);
		return "success";
	}
	
//	@RequestMapping(value = "/{sabun}", method = RequestMethod.DELETE)
	@DeleteMapping("/{sabun}")
	public String delete(@PathVariable int sabun) {
		service.delete(sabun);
		return "success";
	}
}