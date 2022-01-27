package com.test.main.hr.staff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/hr/staff/paystub.do")
public class Paystub extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Object seqStore = session.getAttribute("seq_store");

        PaystubDAO dao = new PaystubDAO();

        ArrayList<PaystubDTO> list = dao.getList((String) seqStore);

        if (list != null) {
            req.setAttribute("list", list);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/hr/staff/paystub.jsp");
        dispatcher.forward(req, resp);
    }
}
