package com.test.main.menu.basic;

/**
 * 메뉴 카테고리 DTO
 * @author 최선희
 */
public class CategoryDTO {

    private String seqCategory;
    private String categoryName;
    private String upperCategory;

    public String getSeqCategory() {
        return seqCategory;
    }

    public void setSeqCategory(String seqCategory) {
        this.seqCategory = seqCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUpperCategory() {
        return upperCategory;
    }

    public void setUpperCategory(String upperCategory) {
        this.upperCategory = upperCategory;
    }
}
