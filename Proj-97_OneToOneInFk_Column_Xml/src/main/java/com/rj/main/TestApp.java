package com.rj.main;

import com.rj.Dao.IMethodImplement;
import com.rj.Dao.OneToOneFk_Col_Impl;
import com.rj.utiality.UtialityImplementation;

public class TestApp
{
  public static void main(String[] args)
  {
	//Call The Methods
	  IMethodImplement Methods=new OneToOneFk_Col_Impl();
	  //Call The meth
	  //Methods.InsertDataUsingChild();
	  Methods.SelectDataUsingChild();
	  
	  //Close The Session Factory..
	  UtialityImplementation.ClosesessionFactory();
  }
}
