package com.test.main.menu.basic;

/**
 * 등록메뉴 DTO
 * @author 최선희
 */
public class RegMenuDTO {

    private String upperCategory;
    private String seqCategory;
    private String categoryName;
    private String seqMenu;
    private String namekr;
    private String nameEn;
    private String regular;
    private String large;
    private String oneSize;
    private String haveProduct;


    public String getSeqCategory() {
        return seqCategory;
    }

    public void setSeqCategory(String seqCategory) {
        this.seqCategory = seqCategory;
    }

    public String getUpperCategory() {
        return upperCategory;
    }

    public void setUpperCategory(String upperCategory) {
        this.upperCategory = upperCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSeqMenu() {
        return seqMenu;
    }

    public void setSeqMenu(String seqMenu) {
        this.seqMenu = seqMenu;
    }

    public String getNamekr() {
        return namekr;
    }

    public void setNamekr(String namekr) {
        this.namekr = namekr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getOneSize() {
        return oneSize;
    }

    public void setOneSize(String oneSize) {
        this.oneSize = oneSize;
    }

    public String getHaveProduct() {
        return haveProduct;
    }

    public void setHaveProduct(String haveProduct) {
        this.haveProduct = haveProduct;
    }
}
