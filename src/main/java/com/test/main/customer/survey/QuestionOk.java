package com.test.main.customer.survey;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/customer/survey/questionok.do") 
public class QuestionOk extends HttpServlet { 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("count");
		
		QuestionDAO dao = new QuestionDAO();
		
		int result = dao.check(id);
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(result);
		
		writer.close();

	}
}
