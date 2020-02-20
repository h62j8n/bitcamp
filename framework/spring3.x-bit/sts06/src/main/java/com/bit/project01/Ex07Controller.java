package com.bit.project01;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

@Controller
public class Ex07Controller {

   @RequestMapping("/ex07")
   public View ex07() {
      View view = new View() {
         
         @Override
         public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
               throws Exception {
        	 PrintWriter out = response.getWriter();
        	 out.print("<h1>7page</h1>");
         }
         
         @Override
         public String getContentType() {
            return "text/json";
         }
      };
      return view;
   }
   
   @RequestMapping("/ex08")
   public void func() {}
   // result : HTTP Status 404 - /project01/WEB-INF/views/ex08.jsp
   // void 메소드로도 view를 결정하는것이 가능하다. (접근하는 URL명을 반환)
}