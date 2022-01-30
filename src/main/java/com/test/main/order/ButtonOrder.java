package com.test.main.order;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 버튼 클릭시 아메리카노 주문 서블릿
 * @author JH LEE
 *
 */
@WebServlet("/order/buttonorder.do") 
public class ButtonOrder extends HttpServlet { 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		//아메리카노
		String txtame = req.getParameter("txtame");
		String txtamedetail = req.getParameter("txtamedetail");
		ListDTO dto = new ListDTO();
		ListDAO dao = new ListDAO();
		dto.setStart_order(txtame);
		dto.setSeq_product(txtamedetail);

		
		
		//주문
		int resultorder = dao.addorder(dto); //tblOrder
		req.setAttribute("resultorder", resultorder);

		int resultdetail = dao.addorderdetail(dto);//tblOrderDetail
		req.setAttribute("resultdetail", resultdetail);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/order/buttonorder.jsp");
		dispatcher.forward(req, resp);
	}

}
