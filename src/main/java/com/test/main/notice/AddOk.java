package com.test.main.notice;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/notice/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		
		
//		dto.setId(session.getAttribute("id").toString());
		dto.setTitle(title);
		dto.setContent(content);
//		dto.setUserip(req.getRemoteAddr());
		
		
		
		int result = dao.add(dto); //1, 0
		
		//4.
		req.setAttribute("result", result);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/notice/addok.jsp");
		dispatcher.forward(req, resp);
	}

}
