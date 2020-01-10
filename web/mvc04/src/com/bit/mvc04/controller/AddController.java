package com.bit.mvc04.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc04.model.Emp05Dao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

@WebServlet("/add.html")
public class AddController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("add.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getRealPath("/upload");			// 현재 서비스중인 실제 경로 반환
		int maxSize = 1024 * 1024 * 10;						// 업로드 파일 크기 증량
		FileRenamePolicy frp = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(req, path, maxSize, "utf-8", frp);			// cos.jar에 의해 실행 가능
		
		String param1 = mr.getParameter("sabun");
		String param2 = mr.getParameter("name");
		String param3 = mr.getFilesystemName("file1");
		String origin = mr.getOriginalFileName("file1");
		
		int sabun = Integer.parseInt(param1);
		String name = param2.trim();
		String file = param3;
		
		try {
			Emp05Dao dao = new Emp05Dao();
			dao.insertOne(sabun, name, file);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("index.html");
	}
}
