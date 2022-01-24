
package com.test.main.store;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/store/netprofit/operating.do") //주소를 적는 부분이고 앞에 code까지 들어가있는 상태이다. do 부분만 적는데 앞에 가상주소가 있으면 그것도 적어준다.
public class OperatingProfit extends HttpServlet { //HttpServlet 상속 받고

	//doGet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/store/operatingprofit.jsp"); //지금 이경로 기본으론 webapp임
		dispatcher.forward(req, resp);
	}
}