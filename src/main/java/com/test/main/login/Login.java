package com.test.main.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login.do")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        if(id == null) {
            doGet(req, resp);
        }

        LoginDAO dao = new LoginDAO();

        LoginDTO result = dao.login(id);
        String error = "";

        if (result == null) {
            error = "존재하지 않는 아이디입니다.";

        } else {
            if (result.getStatus().equals("퇴직")) {
                error = "퇴직하여 이용이 정지된 사용자입니다.";

            } else if (result.getIsLock().equals("y")) {
                req.setAttribute("lock", result.getIsLock());

            } else if (!result.getPassword().equals(pw)) {
                if (result.getLoginFail() == 4) {
                    req.setAttribute("lock", "y");

                } else {
                    error = String.format("올바르지 않은 비밀번호입니다.<br><b>5회 이상 실패시 계정이 잠깁니다. (현재:%d회)</b>",
                            result.getLoginFail() + 1);
                }

                dao.addLoginFail(id);

            } else {
                HttpSession session = req.getSession();

                session.setAttribute("id", result.getSeqEmployee());
                session.setAttribute("name", result.getName());
                session.setAttribute("pic_path", result.getPicPath());
                session.setAttribute("department", result.getDepartment());
                session.setAttribute("position", result.getPosition());
                session.setAttribute("seq_department", result.getSeqDepartment());
                session.setAttribute("seq_position", result.getSeqPosition());
                session.setAttribute("seq_store", result.getSeqStore());

                dao.resetLoginFail(result.getSeqEmployee());

                if (req.getParameter("save_id") != null) {

                    Cookie cookie = new Cookie("id", result.getSeqEmployee());
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    cookie.setPath("/login.do");
                    resp.addCookie(cookie);
                }
            }
        }

        req.setAttribute("error", error);

        dao.closeConn();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
        dispatcher.forward(req, resp);
    }
}
