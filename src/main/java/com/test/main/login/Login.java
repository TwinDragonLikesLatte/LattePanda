package com.test.main.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

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
        SHA256 sha256 = new SHA256();
        String error = "";

        if (result == null) {  //입력된 아이디와 일치하는 계정이 존재하지 않는 경우
            error = "존재하지 않는 아이디입니다.";

        } else {  //입력된 아이디와 일치하는 계정이 존재하는 경우
            if (result.getStatus().equals("퇴직")) {  //계정이 퇴직인 경우
                error = "퇴직하여 이용이 정지된 사용자입니다.";

            } else if (result.getIsLock().equals("y")) {  //계정이 잠겨있는 경우
                req.setAttribute("lock", result.getIsLock());

            } else if (!result.getPassword().equals(sha256.encrypt(pw))) {  //비밀번호가 일치하지 않는 경우
                if (result.getLoginFail() == 4) {  //이전 로그인 실패 횟수가 4회가 넘은 경우 계정 잠금, 잠금 로직은 DB에 트리거로 구현
                    req.setAttribute("lock", "y");

                } else {  //이전 로그인 실패 횟수가 4회 미만인 경우 현재 실패 횟수와 계정 잠금 안내를 출력
                    error = String.format("올바르지 않은 비밀번호입니다.<br><b>5회 이상 실패시 계정이 잠깁니다. (현재:%d회)</b>",
                            result.getLoginFail() + 1);
                }

                dao.addLoginFail(id);

            } else {  //로그인에 성공한 경우
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

                if (req.getParameter("save_id") != null) {  //아이디 저장 기능이 체크되어 있는 경우

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
