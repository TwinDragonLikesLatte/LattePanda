package com.test.main.login;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public LoginDAO() {

        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            System.out.println("LoginDAO.LoginDAO()");
            e.printStackTrace();
        }
    }

    public void closeConn() {

        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("LoginDAO.closeConn()");
            e.printStackTrace();
        }
    }

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

    public String findById(String id) {

        try {

            String sql = "SELECT * FROM tblEmployee WHERE seq_employee = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);

            ResultSet rs = pstat.executeQuery();

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

    public String findByPersonal(LoginDTO dto) {

        try {

            String sql = "SELECT * FROM tblEmployee WHERE seq_employee = ? AND name = ? AND ssn LIKE ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getSeqEmployee());
            pstat.setString(2, dto.getName());
            pstat.setString(3, "%-" + dto.getSsn());

            ResultSet rs = pstat.executeQuery();

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

    public boolean isPwSame(LoginDTO dto) {

        try {

            String sql = "SELECT * FROM tblEmployee WHERE seq_employee = ? AND password = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getSeqEmployee());
            pstat.setString(2, dto.getPassword());

            ResultSet rs = pstat.executeQuery();

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
}
