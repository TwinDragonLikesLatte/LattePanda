package com.test.main.order;

public class ListDTO {
	
	public String seq_order;
	public String seq_store;
	public String start_order;
	public String end_order;
	
	public String name_kr;		//메뉴명
	public String size_name;	//제품 사이즈
	public String total;			//총결제가
	public String name; 		//지점명
	public String rnum; 		//주문번호 순서
	
	public String detail;
	
	
	
	


	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getName_kr() {
		return name_kr;
	}

	public void setName_kr(String name_kr) {
		this.name_kr = name_kr;
	}

	public String getSize_name() {
		return size_name;
	}

	public void setSize_name(String size_name) {
		this.size_name = size_name;
	}

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

	public String getSeq_order() {
		return seq_order;
	}

	public void setSeq_order(String seq_order) {
		this.seq_order = seq_order;
	}

	public String getSeq_store() {
		return seq_store;
	}

	public void setSeq_store(String seq_store) {
		this.seq_store = seq_store;
	}

	public String getStart_order() {
		return start_order;
	}

	public void setStart_order(String start_order) {
		this.start_order = start_order;
	}

	public String getEnd_order() {
		return end_order;
	}

	public void setEnd_order(String end_order) {
		this.end_order = end_order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
