package com.test.main.hr.employee;

import com.test.main.access.AccessController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/hr/employee/list.do")
public class List extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AccessController ac = new AccessController();
        ac.checkAccessible(req, resp);

        String seqDepartment = req.getParameter("seq_department");

        if (seqDepartment == null) {
            seqDepartment = "";
        }

        if (seqDepartment.equals("all")) {
            seqDepartment = "";
        }

        EmployeeDAO dao = new EmployeeDAO();
        ArrayList<EmployeeDTO> list = dao.getList(seqDepartment);

        req.setAttribute("list", list);

        dao.closeConn();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/hr/employee/list.jsp");
        dispatcher.forward(req, resp);
    }
}
