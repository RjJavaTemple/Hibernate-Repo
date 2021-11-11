package com.rj.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "AnnoDriInheri_Emp")
@DiscriminatorValue("Emp")
@PrimaryKeyJoinColumn(name = "PersionId",referencedColumnName = "ID")
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
