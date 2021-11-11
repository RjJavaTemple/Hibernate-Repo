package com.rj.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("Emp")
public class Employee extends Persion
{
	@Column(length = 20)
  private String Degs;
	@Column(length = 20)
  private String Dept;
  private Double Salary;
  
  //Create The ToString Method
  @Override
  public String toString() {
  	return "Employee [Degs=" + Degs + ", Dept=" + Dept + ", Salary=" + Salary + "]";
  }
}
