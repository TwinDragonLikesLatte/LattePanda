package com.test.main.hr.department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/hr/department/orgchartdata.do")
public class OrgChartData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String seqDepartment = req.getParameter("seq_department");

        System.out.println(seqDepartment);

        DepartmentDAO dao = new DepartmentDAO();

        ArrayList<DepartmentDTO> list = dao.getList();

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        StringBuilder sb = new StringBuilder();

        if (list != null) {
            sb.append("[");
            for (DepartmentDTO dto : list) {
                sb.append(String.format("{\"seq_department\":\"%s\", \"name\":\"%s\", \"upper_department\":\"%s\"},",
                        dto.getSeqDepartment(), dto.getName(), dto.getUpperDepartment()));
            }
            sb.delete(sb.length()-1, sb.length());
            sb.append("]");
        }

        writer.print(sb.toString());

        dao.closeConn();
        writer.close();
    }
}
