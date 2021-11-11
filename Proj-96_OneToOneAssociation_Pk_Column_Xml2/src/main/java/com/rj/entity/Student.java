package com.rj.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Student implements Serializable 
{
    private Integer StuId;
    @NonNull
    private String StuName;
    @NonNull
    private String StuAddress;
    
    //Add The Libery Object Hear
    private Libeary LiberyDetails;
    
    //Creat The o-Parms Constructure
    public Student()
    {
    	System.out.println("Student:: 0-Parms Constructure");
	}
    
    //Create The  To String Method
    @Override
	public String toString()
    {
		return "Student [StuId=" + StuId + ", StuName=" + StuName + ", StuAddress=" + StuAddress + "]";
	}
}
