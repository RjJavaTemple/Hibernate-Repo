package com.rj.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "OTO_ANNO_Fk_Col_LICENCETAB2")
public class DrivingLience implements Serializable
{
   //Create The Requirement Instance Variable
	@Id
	@SequenceGenerator(name = "gen2",sequenceName = "Lib_Seq_FK",initialValue = 101001,allocationSize = 1)
	@GeneratedValue(generator = "gen2",strategy = GenerationType.SEQUENCE)
	private Long LibId;
	@NonNull
	private String Type;
	@NonNull
	private LocalDateTime DateOfIssue;
	
	//Add The ParentClass In The Child Class
	@NonNull
	@OneToOne(targetEntity = Persion.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	@JoinColumn(name = "Persion_Id",referencedColumnName = "Pid")
	private Persion LincenceHolder;

	
	//Create The ToString Method
	@Override
	public String toString() 
	{
		return "DrivingLience [LibId=" + LibId + ", Type=" + Type + ", DateOfIssue=" + DateOfIssue + "]";
	}
	
	//Create The Constructure
	public DrivingLience() 
	{
		System.out.println("DrivingLience::0-Parms Constructure..");
	}
}
