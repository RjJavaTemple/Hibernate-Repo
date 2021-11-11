package com.rj.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "OTO_ANNO_Fk_Col_PerTAB1")
public class Persion implements Serializable
{
    //Create The Required Instance Variable
	@Id
	@GenericGenerator(name = "gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	private Integer Pid;
	@NonNull
	private String Pname;
	@NonNull
	private String Paddress;
	
	
	//Create The To StringMethod
	@Override
	public String toString()
	{
		return "Persion [Pid=" + Pid + ", Pname=" + Pname + ", Paddress=" + Paddress + "]";
	}
	
	//Create The Constructure
	public Persion()
	{
		System.out.println("Persion::0-Parms Constructure..");
	}
}
