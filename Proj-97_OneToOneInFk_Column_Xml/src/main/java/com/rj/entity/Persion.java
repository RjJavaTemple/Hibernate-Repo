package com.rj.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Persion implements Serializable
{
    //Create The Required Instance Variable
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
