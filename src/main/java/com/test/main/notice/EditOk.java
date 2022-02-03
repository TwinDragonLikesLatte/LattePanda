package com.test.main.notice;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 공지사항 수정 확인
 * @author JH LEE
 *
 */
@WebServlet("/notice/editok.do")
public class EditOk extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		//2.
		String seq_notice = req.getParameter("seq");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//3.
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = new BoardDTO();
		dto.setSeq_notice(seq_notice);
		dto.setTitle(title);
		dto.setContent(content);
		
		int result = dao.edit(dto); //1,0
		
		//4.
		req.setAttribute("result", result);
		req.setAttribute("seq", seq_notice);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/notice/editok.jsp");
		dispatcher.forward(req, resp);
	}

}
