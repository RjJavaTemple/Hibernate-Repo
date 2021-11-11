package com.rj.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Libeary 
{
   private Integer StuLibId;
   @NonNull
   private String BookName;
   @NonNull
   private  String Dept;
   @NonNull
   private LocalDateTime Dor;
   
   //Add The Student Object Hear
   private Student studentDetails;
   
   //Create The 0-parms Constructure
   public Libeary()
   {
	 System.out.println("Libeary::0-Parms Constructure");
   }
   
   //Create The To String Method
	/*@Override
	public String toString()
	{
	     	return "Libeary [StuLibId=" + StuLibId + ", BookName=" + BookName + ", Dept=" + Dept + ", date=" + date+"]";
	}*/
 
}
