package com.test.main.stock;

public class StockDTO {

	private String seq_stock;				//재고 번호
	private String name;					//재고 이름
	private String types;					//재고 종류
	private String unit;					//단위
	private int unit_cost;					//단가
	private String order_unit;				//발주단위
	private int order_cost;					//발주단가
	private String order_unit_quantity;		//발주단위량
	
	
	//StockCheck
	private String seq_stock_check;			//
	private String seq_store;				//매장 번호
	private int pre_quantity;				//재고 장부 수량
	
	
	//StockRecord
	private int quantity;					//재고 실수량
	private int waste;						//폐기량
	private String etc;						//비고
	
	//StockOrder, StockOrderRecord
	private String seq_stock_order;			//발주 고유 번호
	private int quantity_order;
	
	private String seq_stock_order_record;
	
	
	
	
	
	public String getSeq_stock_order_record() {
		return seq_stock_order_record;
	}
	public void setSeq_stock_order_record(String seq_stock_order_record) {
		this.seq_stock_order_record = seq_stock_order_record;
	}
	
	public int getQuantity_order() {
		return quantity_order;
	}
	public void setQuantity_order(int quantity_order) {
		this.quantity_order = quantity_order;
	}
	public String getSeq_stock() {
		return seq_stock;
	}
	public String getSeq_stock_order() {
		return seq_stock_order;
	}
	public void setSeq_stock_order(String seq_stock_order) {
		this.seq_stock_order = seq_stock_order;
	}
	public void setSeq_stock(String seq_stock) {
		this.seq_stock = seq_stock;
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
	public int getUnit_cost() {
		return unit_cost;
	}
	public void setUnit_cost(int unit_cost) {
		this.unit_cost = unit_cost;
	}
	public String getOrder_unit() {
		return order_unit;
	}
	public void setOrder_unit(String order_unit) {
		this.order_unit = order_unit;
	}
	public int getOrder_cost() {
		return order_cost;
	}
	public void setOrder_cost(int order_cost) {
		this.order_cost = order_cost;
	}
	public String getOrder_unit_quantity() {
		return order_unit_quantity;
	}
	public void setOrder_unit_quantity(String order_unit_quantity) {
		this.order_unit_quantity = order_unit_quantity;
	}
	public String getSeq_stock_check() {
		return seq_stock_check;
	}
	public void setSeq_stock_check(String seq_stock_check) {
		this.seq_stock_check = seq_stock_check;
	}
	public String getSeq_store() {
		return seq_store;
	}
	public void setSeq_store(String seq_store) {
		this.seq_store = seq_store;
	}
	public int getPre_quantity() {
		return pre_quantity;
	}
	public void setPre_quantity(int pre_quantity) {
		this.pre_quantity = pre_quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getWaste() {
		return waste;
	}
	public void setWaste(int waste) {
		this.waste = waste;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
}
