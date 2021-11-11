package com.rj.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class BankAccount 
{
  private Long AccountNo;
  @NonNull
  private String BankName;
  @NonNull
  private String AccountType;
  @NonNull
  private String Location;
  //Add The Persion Class Variable
  private Persion persion;
  
  
  
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
