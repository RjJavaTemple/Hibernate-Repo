package com.rj.entity;

import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public  class Persion 
{
   private Integer PId;
   @NonNull
   private String Pname;
   @NonNull
   private String Paddress;
   @NonNull
   private Set<BankAccount> Account;
   
   //Create The Constructure
   public Persion()
   {
	   System.out.println("0-Parms Constructure");
   }
   
   //Create The To String Method
   @Override
   public String toString()
   {
     return "Persion [PId=" + PId + ", Pname=" + Pname + ", Paddress=" + Paddress + ", Account=" + Account + "]";
   }
}
