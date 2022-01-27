package com.test.main.menu.basic;

public class RecipeDTO {

    private String seqProduct;
    private String seqMenu;
    private String seqStock;
    private String name;
    private String unit;
    private String quantity;
    private String unitCost;
    private String onePrice;

    public String getSeqStock() {
        return seqStock;
    }

    public void setSeqStock(String seqStock) {
        this.seqStock = seqStock;
    }

    public String getSeqProduct() {
        return seqProduct;
    }

    public void setSeqProduct(String seqProduct) {
        this.seqProduct = seqProduct;
    }

    public String getSeqMenu() {
        return seqMenu;
    }

    public void setSeqMenu(String seqMenu) {
        this.seqMenu = seqMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getOnePrice() {
        return onePrice;
    }

    public void setOnePrice(String onePrice) {
        this.onePrice = onePrice;
    }
}
