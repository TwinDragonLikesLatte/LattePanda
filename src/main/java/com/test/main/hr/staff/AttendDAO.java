package com.test.main.hr.staff;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class AttendDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public AttendDAO() {

        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            System.out.println("AttendDAO.AttendDAO");
            e.printStackTrace();
        }
    }

    public void closeConn() {

        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("AttendDAO.closeConn()");
            e.printStackTrace();
        }
    }

    public ArrayList<AttendDTO> getWeek(String seqStaff) {

        try {
            String sql = "SELECT * FROM vwStaffAttend WHERE seq_staff = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seqStaff);
            rs = pstat.executeQuery();

            ArrayList<AttendDTO> list = new ArrayList<AttendDTO>();
            while(rs.next()) {
                AttendDTO dto = new AttendDTO();

                System.out.println(rs.getString("work_start"));
                dto.setDay(rs.getString("day"));
                dto.setWorkStart(rs.getString("work_start"));
                dto.setRestStart(rs.getString("rest_start"));
                dto.setRestEnd(rs.getString("rest_end"));
                dto.setWorkEnd(rs.getString("work_end"));
                dto.setWorkMinute(rs.getInt("work_minute"));
                dto.setPay(String.format("%,d", rs.getInt("pay")));
                list.add(dto);
            }

            pstat.close();
            return list;

        } catch (Exception e) {
            System.out.println("AttendDAO.getWeek()");
            e.printStackTrace();
        }

        return null;
    }

    public HashMap<String, Integer> getMonth(String seqStaff) {
        
        try {
            String sql = "SELECT * FROM vwMonthAttend WHERE seq_staff = ?";
            
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seqStaff);
            rs = pstat.executeQuery();
            
            if(rs.next()) {
                HashMap<String, Integer> result = new HashMap<String, Integer>();
                result.put("month_minute", rs.getInt("month_minute"));
                result.put("month_cnt", rs.getInt("month_cnt"));

                pstat.close();
                return result;
            }

        } catch (Exception e) {
            System.out.println("AttendDAO.getMonth()");
            e.printStackTrace();
        }

        return null;
    }

    public int stampAttend(HashMap<String, String> map) {
        
        try {
            String sql = "";

            if (map.get("selected").equals("work_start")) {
                sql = "INSERT INTO tblStaffAttend (seq_staff_attend, seq_staff, status, work_start) VALUES (seqStaffAttend.nextVal, ?, '정상', CURRENT_DATE)";

            } else {
                sql = "UPDATE tblStaffAttend SET " + map.get("selected") + " = CURRENT_DATE WHERE seq_staff = ? AND reg_date = TRUNC(CURRENT_DATE - 0.05, 'dd')";
            }

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, map.get("seqStaff"));

            int result = pstat.executeUpdate();

            pstat.close();
            return result;
            
        } catch (Exception e) {
            System.out.println("AttendDAO.stampAttend()");
            e.printStackTrace();
        }

        return 0;
    }

    public Boolean pwValid(HashMap<String, String> map) {

        try {
            String sql = "SELECT * FROM tblStaff WHERE seq_staff = ? AND password = ?";

            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, map.get("seqStaff"));
            pstat.setString(2, map.get("pw"));
            ResultSet rs = pstat.executeQuery();

            if(rs.next()) {
                return true;
            }

            pstat.close();

        } catch (Exception e) {
            System.out.println("AttendDAO.pwValid()");
            e.printStackTrace();
        }

        return false;
    }
}
