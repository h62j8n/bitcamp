package com.bit.last;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		RestTemplate template = new RestTemplate();
		
		String url = "http://localhost:8080/last/list";
		ResponseEntity<String> entity = template.getForEntity(url, String.class);
		String msg = entity.getBody();
		model.addAttribute("msg", msg);
		
		return "home";
	}
}
