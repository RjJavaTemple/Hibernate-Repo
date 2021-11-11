package HibernetEntityFiles;

public class StudentTableSetterGetter 
{
  private Integer rollno;
  private String name;
  private Double mark;
  private String address;
  private Double avg;
  private String status;
public Integer getRollno() {
	return rollno;
}
public void setRollno(Integer rollno) {
	this.rollno = rollno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getMark() {
	return mark;
}
public void setMark(Double mark) {
	this.mark = mark;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Double getAvg() {
	return avg;
}
public void setAvg(Double avg) {
	this.avg = avg;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "StudentTableSetterGetter [rollno=" + rollno + ", name=" + name + ", mark=" + mark + ", address=" + address
			+ ", avg=" + avg + ", status=" + status + "]";
}


}
