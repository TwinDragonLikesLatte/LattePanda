package com.test.main.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginbtn.do")
public class LoginBtn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String seqEmployee = req.getParameter("seq_employee");
        HttpSession session = req.getSession();

        if (seqEmployee.equals("logout")) {
            session.removeAttribute("id");
            session.removeAttribute("name");
            session.removeAttribute("pic_path");
            session.removeAttribute("department");
            session.removeAttribute("position");
            session.removeAttribute("seq_department");
            session.removeAttribute("seq_position");
            session.removeAttribute("seq_store");

        } else {
            LoginDAO dao = new LoginDAO();
            LoginDTO result = dao.login(seqEmployee);

            session.setAttribute("id", result.getSeqEmployee());
            session.setAttribute("name", result.getName());
            session.setAttribute("pic_path", result.getPicPath());
            session.setAttribute("department", result.getDepartment());
            session.setAttribute("position", result.getPosition());
            session.setAttribute("seq_department", result.getSeqDepartment());
            session.setAttribute("seq_position", result.getSeqPosition());
            session.setAttribute("seq_store", result.getSeqStore());
        }

        resp.sendRedirect("/index.jsp");
    }
}
