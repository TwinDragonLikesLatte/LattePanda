package com.test.main.login;

public class LoginDTO {

    //기본정보
    private String seqEmployee;
    private String name;
    private String password;
    private String picPath;
    private String department;
    private String position;

    //접근권한
    private String seqDepartment;
    private String seqPosition;
    private String seqStore;

    //계정잠금
    private String status; //퇴직일 경우 실패
    private String isLock; //y일 경우 실패
    private int loginFail; //실패할 경우 +1, 5가 되면 lock
    private int findFail; //실패할 경우 +1, 5가 되면 lock

    //비밀번호 찾기
    private String ssn;

    public String getSeqStore() {
        return seqStore;
    }

    public void setSeqStore(String seqStore) {
        this.seqStore = seqStore;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSeqEmployee() {
        return seqEmployee;
    }

    public void setSeqEmployee(String seqEmployee) {
        this.seqEmployee = seqEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSeqDepartment() {
        return seqDepartment;
    }

    public void setSeqDepartment(String seqDepartment) {
        this.seqDepartment = seqDepartment;
    }

    public String getSeqPosition() {
        return seqPosition;
    }

    public void setSeqPosition(String seqPosition) {
        this.seqPosition = seqPosition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsLock() {
        return isLock;
    }

    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }

    public int getLoginFail() {
        return loginFail;
    }

    public void setLoginFail(int loginFail) {
        this.loginFail = loginFail;
    }

    public int getFindFail() {
        return findFail;
    }

    public void setFindFail(int findFail) {
        this.findFail = findFail;
    }
}
