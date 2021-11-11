package com.rj.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "AnnoDriInheri_Cos")
@DiscriminatorValue("Cos")
@PrimaryKeyJoinColumn(name = "PersionId",referencedColumnName = "ID")
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
