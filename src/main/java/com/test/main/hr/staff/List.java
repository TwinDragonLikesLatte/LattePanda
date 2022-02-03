package com.test.main.hr.staff;

import com.test.main.hr.department.DepartmentDAO;
import com.test.main.hr.department.DepartmentDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/hr/staff/list.do")
public class List extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String seqDepartment = req.getParameter("seq_department");

        if (seqDepartment != null) {
            if (seqDepartment.equals("all")) {
                seqDepartment = "";
            }

            StaffDAO sDao = new StaffDAO();
            ArrayList<StaffDTO> list = sDao.getList(seqDepartment);

            req.setAttribute("list", list);

            sDao.closeConn();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/hr/staff/list.jsp");

        dispatcher.forward(req, resp);
    }
}
