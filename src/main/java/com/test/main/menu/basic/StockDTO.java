package com.test.main.menu.basic;

/**
 * 재고 DTO
 * @author 최선희
 */
public class StockDTO {

    private String seqStock;
    private String name;
    private String types;
    private String unit;
    private String unitCost;
    private String orderUnit;
    private String orderCost;
    private String orderUnitQuantity;

    public String getSeqStock() {
        return seqStock;
    }

    public void setSeqStock(String seqStock) {
        this.seqStock = seqStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getOrderUnit() {
        return orderUnit;
    }

    public void setOrderUnit(String orderUnit) {
        this.orderUnit = orderUnit;
    }

    public String getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    public String getOrderUnitQuantity() {
        return orderUnitQuantity;
    }

    public void setOrderUnitQuantity(String orderUnitQuantity) {
        this.orderUnitQuantity = orderUnitQuantity;
    }
}
