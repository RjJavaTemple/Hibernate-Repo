package com.rj.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JOBDETAILS_TAB1")

public class Persion implements Serializable  
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer PersioId;
	
	@NonNull
   private String PersionName;
	@NonNull
   private String PersionAddress;
	@NonNull
   private String PersionColor;

    //Add The Details File In The Persion Class
	@NonNull
	@Embedded
   private Dtails Details;


	//Create The To String Method
	@Override
	public String toString() {
		return "Persion [PersioId=" + PersioId + ", PersionName=" + PersionName + ", PersionAddress=" + PersionAddress
				+ ", PersionColor=" + PersionColor + "]";
	}
}
