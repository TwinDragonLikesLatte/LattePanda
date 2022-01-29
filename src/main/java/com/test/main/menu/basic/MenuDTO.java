package com.test.main.menu.basic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 메뉴 DTO
 * @author 최선희
 */
public class MenuDTO {

    private String seqMenu;
    private String nameKr;
    private String nameEn;

    private String seqCategory;
    private String large;
    private String regular;
    private String oneSize;
    private String isSizeSell;

    private ArrayList<String> menuSizeList;

    public ArrayList<String> getMenuSize() {
        return menuSizeList;
    }

    public void setMenuSize(ArrayList<String> menuSizeList) {
        this.menuSizeList = menuSizeList;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getOneSize() {
        return oneSize;
    }

    public void setOneSize(String oneSize) {
        this.oneSize = oneSize;
    }

    public String getSeqCategory() {
        return seqCategory;
    }

    public void setSeqCategory(String seqCategory) {
        this.seqCategory = seqCategory;
    }


    public String getIsSizeSell() {
        return isSizeSell;
    }

    public void setIsSizeSell(String isSizeSell) {
        this.isSizeSell = isSizeSell;
    }

    public String getSeqMenu() {
        return seqMenu;
    }

    public void setSeqMenu(String seqMenu) {
        this.seqMenu = seqMenu;
    }

    public String getNameKr() {
        return nameKr;
    }

    public void setNameKr(String nameKr) {
        this.nameKr = nameKr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
}
