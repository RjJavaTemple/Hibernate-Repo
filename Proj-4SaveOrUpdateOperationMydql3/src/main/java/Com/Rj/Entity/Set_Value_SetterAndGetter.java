package Com.Rj.Entity;

public class Set_Value_SetterAndGetter 
{
	
	//Declare The wrapper Class Object
  private Integer sno;
  private String name;
  private String address;
  private Double mark;
  private Double avg;
  private Character grade;

  
  //Genarte The Setter And Getter Method..
  public Integer getSno()
  {
	return sno;
  }
public void setSno(Integer sno)
{
	this.sno = sno;
}
public String getName()
{
	return name;
}
public void setName(String name)
{
	this.name = name;
}
public String getAddress()
{
	return address;
}
public void setAddress(String address)
{
	this.address = address;
}
public Double getMark()
{
	return mark;
}
public void setMark(Double mark)
{
	this.mark = mark;
}
public Double getAvg() 
{
	return avg;
}
public void setAvg(Double avg)
{
	this.avg = avg;
}
public Character getGrade() 
{
	return grade;
}
public void setGrade(Character grade) 
{
	this.grade = grade;
}

//Generate To-string Method
@Override
public String toString() 
{
	return "Set_Value_SetterAndGetter [sno=" + sno + ", name=" + name + ", address=" + address + ", mark=" + mark
			+ ", avg=" + avg + ", grade=" + grade + "]";
}
  
  
}
