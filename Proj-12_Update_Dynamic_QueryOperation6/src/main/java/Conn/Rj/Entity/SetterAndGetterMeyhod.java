package Conn.Rj.Entity;

public class SetterAndGetterMeyhod 
{
      
	  //Bean Propertys.............
		private Integer pid;
		private String pname;
		private Double price;
		private Double qty;
		private String status;
		private String catogery;
		
		//Generate Setter And Gertter Method
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
		public void setPrice(Double price) {
			this.price = price;
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
			this.status = status;
		}
		
		//ToString
		@Override
		public String toString() {
			return "SetterAndGetterMeyhod [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty
					+ ", status=" + status + "]";
		}
		public String getCatogery() {
			return catogery;
		}
		public void setCatogery(String catogery) {
			this.catogery = catogery;
		}
		
		
		
}
