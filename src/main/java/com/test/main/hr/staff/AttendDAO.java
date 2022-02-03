package com.test.main.hr.staff;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 스태프 근태입력 기능을 수행하기 위한 DAO 클래스
 * @author 조진욱
 */
public class AttendDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * DAO 생성자
     * @author 조진욱
     */
    public AttendDAO() {

        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            System.out.println("AttendDAO.AttendDAO");
            e.printStackTrace();
        }
    }

    /**
     * Connction 종료 메서드
     * 서블릿 내에서 DAO 사용 종료 후 호출
     * @author 조진욱
     */
    public void closeConn() {

        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("AttendDAO.closeConn()");
            e.printStackTrace();
        }
    }

    /**
     * 주 근태 상세 목록을 반환하는 메서드
     * @param seqStaff 스태프번호
     * @return 주 근태 상세 목록
     */
    public ArrayList<AttendDTO> getWeek(String seqStaff) {

        try {
            String sql = "SELECT * FROM vwThisWeekAttend WHERE seq_staff = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seqStaff);
            rs = pstat.executeQuery();

            ArrayList<AttendDTO> list = new ArrayList<AttendDTO>();
            while(rs.next()) {
                AttendDTO dto = new AttendDTO();

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

    /**
     * 월 근무일수, 근무시간을 반환하는 메서드
     * @param seqStaff 스태프번호
     * @return 월 근무일수, 근무시간
     */
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

    /**
     * 스태프 근태입력 메서드
     * @param map 스태프번호, 근태종류
     * @return 성공할 경우 1
     */
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

    /**
     * 스태프 비밀번호 일치 확인 메서드
     * @param map 스태프번호, 비밀번호
     * @return 성공할 경우 true
     */
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
