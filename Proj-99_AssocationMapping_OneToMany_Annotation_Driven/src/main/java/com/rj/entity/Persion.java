package com.rj.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "OTM_Anno_Tab1")
public  class Persion 
{
	@Id
	@GenericGenerator(name = "gen1" ,strategy = "increment")
	@GeneratedValue(generator = "gen1")
   private Integer PId;
   @NonNull
   private String Pname;
   @NonNull
   private String Paddress;
   @NonNull
   
   @OneToMany(targetEntity = BankAccount.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
   @JoinColumn(name = "Persion_Id",referencedColumnName = "PID")   
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
