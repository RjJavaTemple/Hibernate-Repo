package com.rj.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "OTM_Anno_ByDir2")
public class BankAccount 
{
	@Id
	@SequenceGenerator(name = "gen4",sequenceName = "Bank_SeqByDir",initialValue = 101001,allocationSize = 1)
	@GeneratedValue(generator = "gen4",strategy = GenerationType.SEQUENCE)
  private Long AccountNo;
  @NonNull
  private String BankName;
  @NonNull
  private String AccountType;
  @NonNull
  private String Location;
  
  //Add The Required Jpa Under Person Class
  @ManyToOne(targetEntity = Persion.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  @JoinColumn(name = "Persion_Id", referencedColumnName = "PID")
  @LazyToOne(LazyToOneOption.PROXY)
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
