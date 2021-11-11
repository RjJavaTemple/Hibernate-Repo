package com.rj.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class DrivingLience implements Serializable
{
   //Create The Requirement Instance Variable
	private Long LibId;
	@NonNull
	private String Type;
	@NonNull
	private LocalDateTime DateOfIssue;
	
	//Add The ParentClass In The Child Class
	@NonNull
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
