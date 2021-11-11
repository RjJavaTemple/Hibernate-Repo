package com.rj.entity;

public class product 
{
  //Bean Propertys.............
	private Integer pid;
	private String pname;
	private Double price;
	private Double qty;
	private String status;
	
	//setter and getter method..........
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double i) {
		this.price = i;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	
	//To String
	@Override
	public String toString() {
		return "product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + ", status=" + status
				+ "]";
	}
	
}
