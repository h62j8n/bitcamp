package com.bit.prj04;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.bit.prj04.model.EmpDao;
import com.bit.prj04.model.entity.EmpVo;

@Controller
public class HomeController {
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping("/emp/list")
	public String list(Model model) throws Exception {
		EmpDao obj = sqlSession.getMapper(EmpDao.class);
		model.addAttribute("list", obj.selectAll());
		return "emplist";
	}
   
	@RequestMapping("/emp/detail/{sabun}")
	public String detail(Model model, @PathVariable int sabun) throws Exception {
		EmpDao obj = sqlSession.getMapper(EmpDao.class);
		model.addAttribute("bean", obj.selectOne(sabun));
		return "empone";
	}
	
	@RequestMapping(value = "/emp/add", method = RequestMethod.GET)
	public String add() {
		
		return "empadd";
	}
	@RequestMapping(value = "/emp/add", method = RequestMethod.POST)
	public String add(EmpVo bean) throws Exception {
		EmpDao obj = sqlSession.getMapper(EmpDao.class);
		obj.insertOne(bean);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/emp/edit", method = RequestMethod.POST)
	public String edit(EmpVo bean) throws Exception {
		EmpDao obj = sqlSession.getMapper(EmpDao.class);
		obj.updateOne(bean);
		return "redirect:detail/" + bean.getSabun();
	}
	
	@RequestMapping(value = "/emp/delete", method = RequestMethod.POST)
	public View delete(int sabun) throws Exception {
		EmpDao obj = sqlSession.getMapper(EmpDao.class);
		
		if (obj.deleteOne(sabun) > 0) {
			// 상태코드 전달 : 정상 삭제했을 경우 코드넘버200 뷰페이지 전송
			return new View() {
				@Override
				public String getContentType() {
					return null;
				}
				@Override
				public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
						throws Exception {
					response.setStatus(200);
				}
			};
		} else {
			return new View() {
				@Override
				public String getContentType() {
					return null;
				}
				@Override
				public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
						throws Exception {
					response.setStatus(404);
				}
			};
		}
	}
}