package com.rj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "BankCoustDetalis_TX")
@RequiredArgsConstructor
public class BankCoustmor 
{
	@Id
	@SequenceGenerator(name = "Gen1",sequenceName = "Seq_BankTx",initialValue = 101001,allocationSize = 1)
	@GeneratedValue(generator = "Gen1")
     private Integer PerId;
	@NonNull
     private String PerName;
	@NonNull
     private Integer Amount;
     
}
