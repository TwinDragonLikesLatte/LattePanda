package com.test.main.hr.employee;

import com.test.main.hr.staff.StaffDTO;
import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 직원관리 기능을 수행하기 위한 DAO 클래스
 * @author 조진욱
 */
public class EmployeeDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * DAO 생성자
     * @author 조진욱
     */
    public EmployeeDAO() {

        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            System.out.println("EmployeeDAO.EmployeeDAO");
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
            System.out.println("EmployeeDAO.closeConn()");
            e.printStackTrace();
        }
    }

    /**
     * 직원목록을 반환하는 메서드
     * @param seqDepartment 부서번호
     * @return 직원목록
     */
    public ArrayList<EmployeeDTO> getList(String seqDepartment) {

        String whereDepartment = "";

        if (!seqDepartment.equals("")) {
            whereDepartment = "AND seq_department = " + seqDepartment;
        }

        try {

            String sql = "SELECT * FROM vwEmplList WHERE NOT status = '퇴직'" + whereDepartment + " ORDER BY seq_department ASC, seq_position ASC";

            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();

            while(rs.next()) {
                String seqEmployee = rs.getString("seq_Employee");
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String mail = rs.getString("mail");
                String department = rs.getString("department");
                String position = rs.getString("position");
                String join = rs.getString("join").substring(0, 10);

                EmployeeDTO dto = new EmployeeDTO();
                dto.setSeqEmployee(seqEmployee);
                dto.setName(name);
                dto.setTel(tel);
                dto.setMail(mail);
                dto.setDepartment(department);
                dto.setPosition(position);
                dto.setJoin(join);
                list.add(dto);
            }

            stat.close();
            return list;

        } catch (Exception e) {
            System.out.println("StaffDAO.getList()");
            e.printStackTrace();
        }

        return null;
    }
}
