package com.test.main.hr.staff;

public class PaystubDTO {

    private String name;
    private String seqStaff;
    private String yearMonth;
    private int time;
    private int total;
    private int real;
    private int basic;
    private int holiday;
    private int over;
    private int night;
    private int gukmin;
    private int gungang;
    private int goyong;
    private int incomeTax;
    private int localTax;
    private String transfer;

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeqStaff() {
        return seqStaff;
    }

    public void setSeqStaff(String seqStaff) {
        this.seqStaff = seqStaff;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBasic() {
        return basic;
    }

    public void setBasic(int basic) {
        this.basic = basic;
    }

    public int getHoliday() {
        return holiday;
    }

    public void setHoliday(int holiday) {
        this.holiday = holiday;
    }

    public int getOver() {
        return over;
    }

    public void setOver(int over) {
        this.over = over;
    }

    public int getNight() {
        return night;
    }

    public void setNight(int night) {
        this.night = night;
    }

    public int getGukmin() {
        return gukmin;
    }

    public void setGukmin(int gukmin) {
        this.gukmin = gukmin;
    }

    public int getGungang() {
        return gungang;
    }

    public void setGungang(int gungang) {
        this.gungang = gungang;
    }

    public int getGoyong() {
        return goyong;
    }

    public void setGoyong(int goyong) {
        this.goyong = goyong;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(int incomeTax) {
        this.incomeTax = incomeTax;
    }

    public int getLocalTax() {
        return localTax;
    }

    public void setLocalTax(int localTax) {
        this.localTax = localTax;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }
}
