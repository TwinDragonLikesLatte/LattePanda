package com.test.main.hr.department;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartmentDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public DepartmentDAO() {

        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            System.out.println("DepartmentDAO.DepartmentDAO");
            e.printStackTrace();
        }
    }

    public void closeConn() {

        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("DepartmentDAO.closeConn()");
            e.printStackTrace();
        }
    }

    public ArrayList<DepartmentDTO> getList() {

        try {

            String sql = "SELECT * FROM tblDepartment ORDER BY LENGTH(seq_department)";

            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            ArrayList<DepartmentDTO> list = new ArrayList<>();

            while(rs.next()) {
                DepartmentDTO dto = new DepartmentDTO();
                dto.setSeqDepartment(rs.getString("seq_department"));
                dto.setName(rs.getString("name"));
                list.add(dto);
            }

            pstat.close();
            return list;

        } catch (Exception e) {
            System.out.println("DepartmentDAO.getList()");
            e.printStackTrace();
        }



        return null;
    }
}
