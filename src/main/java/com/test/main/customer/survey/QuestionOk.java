package com.test.main.customer.survey;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/customer/survey/questionok.do") 
public class QuestionOk extends HttpServlet { 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String ordercheck = req.getParameter("ordercheck");
		
		QuestionDAO dao = new QuestionDAO();
		QuestionDTO dto = new QuestionDTO();
		
		
//		int result = dao.check(dto); 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customer/survey/questionok.jsp");
		dispatcher.forward(req, resp);
	}

}
