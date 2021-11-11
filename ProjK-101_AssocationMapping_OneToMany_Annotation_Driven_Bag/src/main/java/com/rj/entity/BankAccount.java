package com.rj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "OTM_Anno_Bag2")
public class BankAccount 
{
	@Id
	@SequenceGenerator(name = "gen3",sequenceName = "Bank_SeqBAG",initialValue = 101001,allocationSize = 1)
	@GeneratedValue(generator = "gen3",strategy = GenerationType.SEQUENCE)
  private Long AccountNo;
  @NonNull
  private String BankName;
  @NonNull
  private String AccountType;
  @NonNull
  private String Location;
  
  //Create A Constructure
  public BankAccount()
  {
	  System.out.println("0-Parms Constructure");
  }
  
  //Use The To String Method
  @Override
  public String toString()
  {
     return "BankAccount [AccountNo=" + AccountNo + ", BankName=" + BankName + ", AccountType=" + AccountType
  	   + ", Location=" + Location + "]";
  }
}
