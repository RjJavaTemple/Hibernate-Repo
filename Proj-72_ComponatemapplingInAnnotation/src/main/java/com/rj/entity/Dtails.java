package com.rj.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Dtails implements Serializable 
{
	//Required Column In The The Sql Table

  private String Degs;
@NonNull
  private String CompanyName;
@NonNull
  private Integer DeptNo;
@NonNull
  private Double Salary;


  //Use The To-string Methos Are required The Client Side App
@Override
public String toString() {
	return "Dtails [Degs=" + Degs + ", CompanyName=" + CompanyName + ", DeptNo=" + DeptNo + ", Salary=" + Salary + "]";
}  
  
}
