package com.test.main.hr.employee;

import com.test.main.access.AccessController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hr/employee/add.do")
public class add extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AccessController ac = new AccessController();
        ac.checkAccessible(req, resp);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/hr/employee/add.jsp");
        dispatcher.forward(req, resp);
    }
}
