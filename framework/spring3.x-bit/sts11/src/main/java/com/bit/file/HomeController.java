package com.bit.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	String path = "E:\\Study\\bitcamp\\framework\\spring3.x-bit\\download\\";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("index");
		return "home";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(int sabun, MultipartFile[] files, Model model) {
		logger.debug(sabun+"");
		ArrayList<String> renames = new ArrayList<String>();
		
		for(MultipartFile multi : files) {
			if (multi.getOriginalFilename().isEmpty()) {
				continue;
				// 인풋파일 태그가 비었을 경우
			}
			
			logger.debug(multi.getOriginalFilename());
			
			String filename = multi.getOriginalFilename();
			String rename = System.currentTimeMillis()+"_"+filename;
			// 업로드 되는 파일의 파일명이 중복될 수 없도록 유도
			
			renames.add(rename);
			File file = new File(path + rename);
			
			try {
				multi.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		model.addAttribute("sabun", sabun);
		model.addAttribute("files", renames);
		
		return "download";
	}
	
	@RequestMapping("/download/{filename:.+}")	// :.+ 파라미터로 받는 POST방식에서는 잘 되지만 GET방식에서는 확장자를 받지 못한다.
	public void download(@PathVariable String filename, HttpServletResponse res) {
		String origin = filename.substring(filename.indexOf("_")+1);
		
		File file = new File(path + filename);
		res.setContentType("application/octet-stream");
		// 16bit 유닉스 체계에서 사용하던 메모장 타입.
		// 브라우저가 알지 못하는 타입을 지정하여 다운로드 처리하도록 유도
		res.setHeader("Content-Disposition", "attachment; filename=\"" + origin + "\"");
		// 다운로드는 본래의 파일명으로 받도록 처리
		try {
			InputStream is = new FileInputStream(file);
			OutputStream os = res.getOutputStream();
			
			int su = -1;
			while ((su = is.read()) != -1) {
				os.write(su);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
