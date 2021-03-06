package com.test.main.notice;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 공지사항 삭제 서블릿
 * @author JH LEE
 *
 */
@WebServlet("/notice/del.do")
public class Del extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String seq = req.getParameter("seq_notice");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.get(seq);
	
		
		
		//2.
		req.setAttribute("seq", seq);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/notice/del.jsp");
		dispatcher.forward(req, resp);

	}

}
