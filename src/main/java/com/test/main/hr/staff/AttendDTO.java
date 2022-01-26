package com.test.main.hr.staff;

public class AttendDTO {

    private String seqStaff;
    private String workStart;
    private String restStart;
    private String restEnd;
    private String workEnd;
    private String day;
    private int workMinute;
    private String pay;

    public int getWorkMinute() {
        return workMinute;
    }

    public void setWorkMinute(int workMinute) {
        this.workMinute = workMinute;
    }

    public String getSeqStaff() {
        return seqStaff;
    }

    public void setSeqStaff(String seqStaff) {
        this.seqStaff = seqStaff;
    }

    public String getWorkStart() {
        return workStart;
    }

    public void setWorkStart(String workStart) {
        this.workStart = workStart;
    }

    public String getRestStart() {
        return restStart;
    }

    public void setRestStart(String restStart) {
        this.restStart = restStart;
    }

    public String getRestEnd() {
        return restEnd;
    }

    public void setRestEnd(String restEnd) {
        this.restEnd = restEnd;
    }

    public String getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(String workEnd) {
        this.workEnd = workEnd;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
}
