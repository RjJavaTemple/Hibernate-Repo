package com.rj.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Dtails implements Serializable 
{
	//Required Column In The The Sql Table
@NonNull
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
