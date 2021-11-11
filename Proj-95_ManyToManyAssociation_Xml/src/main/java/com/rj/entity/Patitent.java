package com.rj.entity;

import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Patitent 
{
  private Integer PatId;
  @NonNull
  private String PaiName;
  @NonNull
  private String Problem;
  
  //Create The Doctor Class Object Add The Set under
  private Set<Doctor> Doctor;
  
  
  //Create The Tostring Method
  @Override
  public String toString()
  {
  	  return "Patitent [PatId=" + PatId + ", PaiName=" + PaiName + ", Problem=" + Problem + ", Doctor=" + Doctor + "]";
  }  
  
  
  //Creat The Constructure
  public Patitent()
  {
	 System.out.println("Patitent.0-Parms Constructure");
  }

}
