package com.test.main.login;

import java.security.MessageDigest;

public class SHA256 {

    public String encrypt(String text) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes());

            return bytesToHex(md.digest());

        } catch (Exception e) {
            System.out.println("SHA256.encrypt()");
            e.printStackTrace();
        }

        return null;
    }

    public String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
