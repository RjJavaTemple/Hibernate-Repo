package com.rj.main;

import com.rj.Dao.IOneToOneMethods;
import com.rj.Dao.MethodImpOTO;

public class TestApp
{
  public static void main(String[] args)
  {
	  IOneToOneMethods Ip=new MethodImpOTO();
	  //Ip.InsertDataUsingParent();
	 // Ip.InsertDataUsingChild();
	   Ip.SelectData(); 
  }
}
