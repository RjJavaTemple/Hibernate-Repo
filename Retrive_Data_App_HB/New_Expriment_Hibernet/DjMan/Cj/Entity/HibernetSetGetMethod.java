package DjMan.Cj.Entity;

public class HibernetSetGetMethod 
{
  private Integer empno;
  private Integer empname;
  private Integer empsal;
  private Integer empage;
  private Integer empaddress;
  private Integer empwork;
  
  //Generate Getter nd Setter method...
public Integer getEmpno() {
	return empno;
}
public void setEmpno(Integer empno) {
	this.empno = empno;
}
public Integer getEmpname() {
	return empname;
}
public void setEmpname(Integer empname) {
	this.empname = empname;
}
public Integer getEmpsal() {
	return empsal;
}
public void setEmpsal(Integer empsal) {
	this.empsal = empsal;
}
public Integer getEmpage() {
	return empage;
}
public void setEmpage(Integer empage) {
	this.empage = empage;
}
public Integer getEmpaddress() {
	return empaddress;
}
public void setEmpaddress(Integer empaddress) {
	this.empaddress = empaddress;
}
public Integer getEmpwork() {
	return empwork;
}
public void setEmpwork(Integer empwork) {
	this.empwork = empwork;
}

//Generate To String...

@Override
public String toString() {
	return "HibernetSetGetMethod [empno=" + empno + ", empname=" + empname + ", empsal=" + empsal + ", empage=" + empage
			+ ", empaddress=" + empaddress + ", empwork=" + empwork + "]";
}
}
