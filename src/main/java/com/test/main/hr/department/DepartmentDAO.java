package com.test.main.hr.department;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 부서 관련 기능을 수행하기 위한 DAO 클래스
 * @author 조진욱
 */
public class DepartmentDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * DAO 생성자
     * @author 조진욱
     */
    public DepartmentDAO() {

        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            System.out.println("DepartmentDAO.DepartmentDAO");
            e.printStackTrace();
        }
    }

    /**
     * Connection 종료 메서드
     * 서블릿 내에서 DAO 사용 종료 후 호출
     * @author 조진욱
     */
    public void closeConn() {

        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("DepartmentDAO.closeConn()");
            e.printStackTrace();
        }
    }

    /**
     * 부서목록을 반환하는 메서드
     * @return 부서목록
     * @author 조진욱
     */
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
