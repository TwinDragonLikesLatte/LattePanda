package com.test.main.notice;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/notice/view.do") 
public class View extends HttpServlet { 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String date = req.getParameter("date");
		
		String searchmode = "n";
		
		if ((column == null && word == null) 
				|| (column.equals("") && word.equals(""))) {
			searchmode = "n";
		} else {
			searchmode = "y";
		}
		
		
		String seq = req.getParameter("seq");
		String page = req.getParameter("page");
		
		
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = dao.get(seq);
		
		
		//제목과 내용에 들어있는 태그를 비활성화
//		dto.setTitle(dto.getTitle().replace("<", "&lt;").replace(">", "&gt;"));
//		dto.setContent(dto.getContent().replace("<", "&lt;").replace(">", "&gt;"));
//				
//		//개행 문자 처리
//		dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		
		
		req.setAttribute("dto", dto);
		req.setAttribute("column", column);
		req.setAttribute("word", word);
		req.setAttribute("page", page);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/notice/view.jsp");
		dispatcher.forward(req, resp);
	}

}
