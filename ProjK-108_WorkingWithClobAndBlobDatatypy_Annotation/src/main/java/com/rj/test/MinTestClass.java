package com.rj.test;

import com.rj.dao.IpersonImplClass;
import com.rj.dao.IpersonMethod;
import com.rj.utiality.UtialityImplitation;

public class MinTestClass
{
   public static void main(String[] args)
   {
	  //Create The Class Object And Call The Data
	   IpersonMethod Iper=new IpersonImplClass();
	  // Iper.SaveData();
	   Iper.SelectData();
	   
	   //Close The SessionFactory
	   UtialityImplitation.CloseSessionFactory();
  }
}
