package com.test.main.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findpassword.do")
public class FindPassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/findpwid.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        LoginDAO dao = new LoginDAO();
        LoginDTO dto = new LoginDTO();

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String ssn = req.getParameter("ssn");

        RequestDispatcher dispatcher = null;

        if (id != null && name != null && ssn != null) {  //이름, 주민번호 입력 후
            dto.setSeqEmployee(req.getParameter("id"));
            dto.setName(req.getParameter("name"));
            dto.setSsn(req.getParameter("ssn"));

            String result = dao.findByPersonal(dto);

            if (result != null) {
                req.setAttribute("id", id);
                dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/changepw.jsp");

            } else {
                req.setAttribute("id", id);
                req.setAttribute("error", "정보가 일치하지 않습니다.");
                dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/findpwid.jsp");
            }

        } else {  //아이디 입력 후
            String result = dao.findById(id);

            req.setAttribute("id", id);
            dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/findpwnamessn.jsp");
        }

        dao.closeConn();
        dispatcher.forward(req, resp);
    }
}
