package com.rj.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("Cos")
public class Coustmor extends Persion
{
	@Column
  private Double BillAmount;
  @Column(length = 20)
  private String PaymentType;
  
//Creatr The To String Method
  @Override
  public String toString() {
  	return "Coustmor [BillAmount=" + BillAmount + ", PaymentType=" + PaymentType + "]";
  }

  
}
