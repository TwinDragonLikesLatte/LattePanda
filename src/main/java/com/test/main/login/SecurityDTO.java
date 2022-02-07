package com.test.main.login;

public class SecurityDTO {

    private String salt;
    private int stretch;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getStretch() {
        return stretch;
    }

    public void setStretch(int stretch) {
        this.stretch = stretch;
    }
}
