package com.test.main.order;

/**
 * 데이터 Getter/Setter
 * @author JH LEE
 *
 */
public class ListDTO {
	
	public String seq_order;
	public String seq_store;
	public String start_order;
	public String end_order;
	
	public String name_kr;		//메뉴명
	public String seq_size;	//제품 사이즈
	public String total;		//총결제가
	public String name; 		//지점명
	public String rnum; 		//주문번호 순서
	
	public String detail;
	public String count;
	
	public String refund; 		//환불
	
	public String seq_product;
	
	
	
	

	public String getSeq_size() {
		return seq_size;
	}

	public void setSeq_size(String seq_size) {
		this.seq_size = seq_size;
	}

	public String getSeq_product() {
		return seq_product;
	}

	public void setSeq_product(String seq_product) {
		this.seq_product = seq_product;
	}

	public String getRefund() {
		return refund;
	}

	public void setRefund(String refund) {
		this.refund = refund;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

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
