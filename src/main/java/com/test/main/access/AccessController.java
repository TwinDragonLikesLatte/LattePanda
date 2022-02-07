package com.test.main.access;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 로그인한 사람의 부서와 직위를 기준으로 서블릿 패스 별 접근 권한을 설정하는 클래스
 * @author 조진욱
 */
public class AccessController {

    /**
     * 로그인한 사람의 부서와 직위를 기준으로 서블릿 패스 별 접근 권한을 판단하는 메서드
     * @param req
     * @param resp
     * @author 조진욱
     */
    public void checkAccessible(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();
        String seq_department = (String)session.getAttribute("seq_department");
        String seq_position = (String)session.getAttribute("seq_position");

        String servletPath = req.getServletPath();

        switch (servletPath) {
            case "/hr/employee/list.do" :
                return;

            case "/hr/employee/add.do" :
                if (seq_department.equals("2")
                        || seq_department.equals("22")) {
                    return;
                }
                break;

            case "/hr/staff/list.do" :
                if (seq_department.equals("2")
                        || seq_department.equals("22")
                        || seq_department.indexOf("3") == 0) {
                    return;
                }
                break;

            case "/hr/staff/add.do" :
                if (seq_position.equals("8")) {
                    return;
                }
                break;

            case "/hr/staff/attend.do" :
                if (seq_position.equals("8")
                        || seq_position.equals("9")) {
                    return;
                }
                break;
        }

        kick(resp);
    }

    /**
     * 접근 권한이 없는 사용자를 차단하는 메서드
     * @param resp
     * @author 조진욱
     */
    public void kick(HttpServletResponse resp) {

        try {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");

            PrintWriter writer = resp.getWriter();
            writer.println("<html><body><script>");
            writer.println("alert('권한이 없습니다.'); history.back();");
            writer.println("</script></body></html>");
            writer.close();

        } catch (Exception e) {
            System.out.println("AccessController.kick()");
            e.printStackTrace();
        }
    }
}
