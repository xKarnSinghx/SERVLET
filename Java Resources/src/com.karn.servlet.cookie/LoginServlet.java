package com.karn.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
   
   /**
	 * 
	 */
	private static final long serialVersionUID = -7133950131688156409L;

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String un= request.getParameter("uname");
      String pw= request.getParameter("password");
      
      PrintWriter out=response.getWriter();
      Cookie ck=new Cookie("auth", un);//creating cookie object 
      ck.setMaxAge(600);//setting the maximum age to 600 seconds 
       if(un.equals("karn")&pw.equals("myFirst"))
       {
          response.addCookie(ck);//adding cookie in the response 
          response.sendRedirect("logout.html");
          return;
       }
       else
       {
          RequestDispatcher rd = request.getRequestDispatcher("login.html");
           out.println("<font color=red>Either user name or password is wrong.</font>");
           rd.include(request, response);
       }
   }

}
