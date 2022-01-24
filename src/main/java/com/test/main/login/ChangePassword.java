package com.test.main.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changepassword.do")
public class ChangePassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/changepw.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginDAO dao = new LoginDAO();
        LoginDTO dto = new LoginDTO();

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        RequestDispatcher dispatcher = null;

        dto.setSeqEmployee(id);
        dto.setPassword(pw);

        if (dao.isPwSame(dto)) {
            req.setAttribute("error", "이전 비밀번호와 같습니다.");
            req.setAttribute("id", id);
            dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/changepw.jsp");

        } else {
            int result = dao.changePw(dto);
            dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/changepwok.jsp");
        }

        dao.closeConn();
        dispatcher.forward(req, resp);
    }
}
