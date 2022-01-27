package com.test.main.hr.staff;

public class StaffDTO {

    private String seqStaff;
    private String name;
    private String tel;
    private String store;
    private String contractExpire;
    private String healthExpire;
    private String eduExpire;
    private String join;

    private String status; //퇴직일 경우 실패
    private String seqStore;
    private String seqDepartment;

    private String password;

    public String getSeqStaff() {
        return seqStaff;
    }

    public void setSeqStaff(String seqStaff) {
        this.seqStaff = seqStaff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getContractExpire() {
        return contractExpire;
    }

    public void setContractExpire(String contractExpire) {
        this.contractExpire = contractExpire;
    }

    public String getHealthExpire() {
        return healthExpire;
    }

    public void setHealthExpire(String healthExpire) {
        this.healthExpire = healthExpire;
    }

    public String getEduExpire() {
        return eduExpire;
    }

    public void setEduExpire(String eduExpire) {
        this.eduExpire = eduExpire;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeqStore() {
        return seqStore;
    }

    public void setSeqStore(String seqStore) {
        this.seqStore = seqStore;
    }

    public String getSeqDepartment() {
        return seqDepartment;
    }

    public void setSeqDepartment(String seqDepartment) {
        this.seqDepartment = seqDepartment;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
