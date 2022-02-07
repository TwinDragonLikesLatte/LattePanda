package com.test.main.login;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 로그인 기능을 수행하기 위한 DAO 클래스
 * @author 조진욱
 */
public class LoginDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * DAO 생성자
     * @author 조진욱
     */
    public LoginDAO() {

        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            System.out.println("LoginDAO.LoginDAO()");
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
            System.out.println("LoginDAO.closeConn()");
            e.printStackTrace();
        }
    }

    /**
     * 로그인 메서드
     * @param id 직원번호
     * @return LoginDTO
     * @author 조진욱
     */
    public LoginDTO login(String id) {

        try {

            String sql = "SELECT * FROM vwLogin WHERE seq_employee = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);

            rs = pstat.executeQuery();

            if (rs.next()) {

                LoginDTO result = new LoginDTO();

                result.setSeqEmployee(rs.getString("seq_employee"));
                result.setName(rs.getString("name"));
                result.setPassword(rs.getString("password"));
                result.setPicPath(rs.getString("pic_path"));
                result.setDepartment(rs.getString("department"));
                result.setPosition(rs.getString("position"));
                result.setSeqDepartment(rs.getString("seq_department"));
                result.setSeqPosition(rs.getString("seq_position"));
                result.setSeqStore(rs.getString("seq_store"));
                result.setStatus(rs.getString("status"));
                result.setIsLock(rs.getString("is_lock"));
                result.setLoginFail(rs.getInt("login_fail"));
                result.setFindFail(rs.getInt("find_fail"));

                pstat.close();
                return result;
            }

            pstat.close();

        } catch (Exception e) {
            System.out.println("LoginDAO.login()");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * DB 내 로그인 실패 카운트 추가 메서드
     * @param seqEmployee 직원번호
     * @author 조진욱
     */
    public void addLoginFail(String seqEmployee) {

        try {

            String sql = "UPDATE tblEmployee SET login_fail = (SELECT login_fail FROM tblEmployee WHERE seq_employee = ?) + 1 WHERE seq_employee = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seqEmployee);
            pstat.setString(2, seqEmployee);

            pstat.executeUpdate();
            pstat.close();

        } catch (Exception e) {
            System.out.println("LoginDAO.addLoginFail()");
            e.printStackTrace();
        }
    }

    /**
     * DB 내 로그인 실패 카운트 초기화 메서드
     * @param seqEmployee 직원번호
     * @author 조진욱
     */
    public void resetLoginFail(String seqEmployee) {

        try {

            String sql = "UPDATE tblEmployee SET login_fail = 0, is_lock = 'n' WHERE seq_employee = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seqEmployee);

            pstat.executeUpdate();
            pstat.close();

        } catch (Exception e) {
            System.out.println("LoginDAO.addLoginFail()");
            e.printStackTrace();
        }
    }

    /**
     * 아이디(직원번호)로 계정을 조회하는 메서드
     * @param id 아이디(직원번호)
     * @return 아이디(직원번호)
     * @author 조진욱
     */
    public String findById(String id) {

        try {

            String sql = "SELECT * FROM tblEmployee WHERE seq_employee = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);

            rs = pstat.executeQuery();

            if (rs.next()) {
                pstat.close();
                return id;
            }

        } catch (Exception e) {
            System.out.println("LoginDAO.searchId()");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 직원번호, 이름, 주민등록번호로 회원을 찾는 메서드
     * 직원번호, 이름, 주민등록번호 필요
     * @param dto LoginDTO
     * @return 아이디(직원번호)
     * @author 조진욱
     */
    public String findByPersonal(LoginDTO dto) {

        try {

            String sql = "SELECT * FROM tblEmployee WHERE seq_employee = ? AND name = ? AND ssn LIKE ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getSeqEmployee());
            pstat.setString(2, dto.getName());
            pstat.setString(3, "%-" + dto.getSsn());

            rs = pstat.executeQuery();

            if (rs.next()) {
                pstat.close();
                return dto.getSeqEmployee();
            }

        } catch (Exception e) {
            System.out.println("LoginDAO.findByPersonal()");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 변경할 비밀번호가 기존 비밀번호와 동일한지 확인하는 메서드
     * 직원번호, 비밀번호 필요
     * @param dto LoginDTO
     * @return 동일할 경우 true
     * @author 조진욱
     */
    public boolean isPwSame(LoginDTO dto) {

        try {

            String sql = "SELECT * FROM tblEmployee WHERE seq_employee = ? AND password = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getSeqEmployee());
            pstat.setString(2, dto.getPassword());

            rs = pstat.executeQuery();

            if (rs.next()) {
                pstat.close();
                return true;
            }

        } catch (Exception e) {
            System.out.println("LoginDAO.isPwSame()");
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 해당 직원의 비밀번호를 변경하는 메서드
     * 직원번호, 비밀번호 필요
     * @param dto LoginDTO
     * @return 성공할 경우 1
     */
    public int changePw(LoginDTO dto) {

        try {

            String sql = "UPDATE tblEmployee SET password = ? WHERE seq_employee = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getPassword());
            pstat.setString(2, dto.getSeqEmployee());

            int result = pstat.executeUpdate();

            pstat.close();
            return result;

        } catch (Exception e) {
            System.out.println("LoginDAO.changePw()");
            e.printStackTrace();
        }

        return 0;
    }

    public SecurityDTO getSecurity(String id) {

        try {

            String sql = "SELECT * FROM tblEmplSecurity WHERE seq_employee = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);

            rs = pstat.executeQuery();

            if (rs.next()) {
                SecurityDTO dto = new SecurityDTO();
                dto.setSalt(rs.getString("salt"));
                dto.setStretch(rs.getInt("stretch"));
                pstat.close();
                return dto;
            }

        } catch (Exception e) {
            System.out.println("LoginDAO.getSalt()");
            e.printStackTrace();
        }

        return null;
    }
}
