package com.rj.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ListIndexBase;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "OTM_Anno_BaiDir1")
public  class Persion 
{
	@Id
	@GenericGenerator(name = "gen4" ,strategy = "increment")
	@GeneratedValue(generator = "gen4")
   private Integer PId;
   @NonNull
   private String Pname;
   @NonNull
   private String Paddress;
   @NonNull
   
   @OneToMany(targetEntity = BankAccount.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true,mappedBy ="persion")
   //@JoinColumn(name = "Persion_Id",referencedColumnName = "PID")  NO NEED TO USE THE JOIN COLUMN SEPERATELY JUST USE THE CHILD CLASS MAPPED BY="PERSON	"
   @LazyCollection(LazyCollectionOption.EXTRA)
   @Fetch(FetchMode.JOIN)
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
