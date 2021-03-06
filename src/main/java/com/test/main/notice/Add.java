package com.test.main.notice;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 공지사항 글쓰기
 * @author JH LEE
 *
 */
@WebServlet("/notice/add.do") 
public class Add extends HttpServlet { 

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/notice/add.jsp");
		dispatcher.forward(req, resp);
		
	}

}
