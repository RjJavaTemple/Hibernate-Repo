package com.rj.entity;

import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Doctor 
{
    //Create The All required Variable
	private Integer DocId;
	@NonNull
	private String DocName;
	@NonNull
	private String DocCategory;
	
	//Create The Patient Class Object Are St Property
	private Set<Patitent> Patient;
	
	
	//Create The ToString Method
	@Override
	public String toString()
	{
		return "Doctor [DocId=" + DocId + ", DocName=" + DocName + ", DocCategory=" + DocCategory + ", Patient="
				+ Patient + "]";
	}
	
	
	//Create The Constructure
	public Doctor()
	{
	  System.out.println("Doctor.0-Parms Constructure");	
	}

}
