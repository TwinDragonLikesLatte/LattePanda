package com.test.main.customer.survey;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/survey/question.do")
public class Question extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	String count = req.getParameter("count");
    	QuestionDAO dao = new QuestionDAO();
//    	QuestionDTO dto = dao.get(count);
    	
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customer/survey/question.jsp");
        dispatcher.forward(req, resp);
    }

	
}
