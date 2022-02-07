package com.test.main.hr.staff;

import com.test.main.access.AccessController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/hr/staff/attend.do")
public class Attend extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AccessController ac = new AccessController();
        ac.checkAccessible(req, resp);

        String seqStaff = req.getParameter("seq_staff");

        if (seqStaff != null) {
            StaffDAO sDao = new StaffDAO();
            StaffDTO staff = sDao.getStaff(seqStaff);

            AttendDAO aDao = new AttendDAO();
            ArrayList<AttendDTO> week = aDao.getWeek(seqStaff);

            HashMap<String, Integer> timeCnt = aDao.getMonth(seqStaff);

            if (timeCnt != null && week != null) {
                int week_minute = 0;
                int week_cnt = week.size();

                for (AttendDTO dto : week) {
                    week_minute += dto.getWorkMinute();
                }

                timeCnt.put("week_minute", week_minute);
                timeCnt.put("week_cnt", week_cnt);
            }

            if (staff != null) {
                req.setAttribute("staff", staff);
            }

            if (week != null) {
                req.setAttribute("week", week);
                req.setAttribute("time_cnt", timeCnt);
            }

            sDao.closeConn();
            aDao.closeConn();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/hr/staff/attend.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String seqStaff = req.getParameter("seq_staff");
        String pw = req.getParameter("pw");
        String selected = req.getParameter("selected");

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("seqStaff", seqStaff);
        map.put("pw", pw);
        map.put("selected", selected);

        AttendDAO dao = new AttendDAO();

        if (dao.pwValid(map)) {
            int result = dao.stampAttend(map);

            dao.closeConn();
            resp.sendRedirect("/hr/staff/attend.do?seq_staff=" + seqStaff);

        } else {
            dao.closeConn();
            resp.sendRedirect("/hr/staff/attend.do?seq_staff=" + seqStaff + "&error=y");
        }
    }
}
