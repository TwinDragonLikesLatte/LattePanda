package com.test.main.notice;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 공지사항 삭제 확인
 * @author JH LEE
 *
 */
@WebServlet("/notice/delok.do") 
public class DelOk extends HttpServlet { 


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String seq = req.getParameter("seq");
		
		//3.
		BoardDAO dao = new BoardDAO();
		
		
		int result = dao.del(seq); //1,0
		//4.
		req.setAttribute("result", result);

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/notice/delok.jsp");
		dispatcher.forward(req, resp);

	}

}
