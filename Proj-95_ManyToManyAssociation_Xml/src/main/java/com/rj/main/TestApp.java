package com.rj.main;

import com.rj.Dao.IManyToManyAssociationMethod;
import com.rj.Dao.ImplOfMTMMethods;
import com.sun.istack.Pool.Impl;

public class TestApp
{
  public static void main(String[] args)
  {
	  //Lode The Calling Class
	  IManyToManyAssociationMethod Imp=new ImplOfMTMMethods();
	  //Call The Method
	  //Imp.InsertDataUsingParent();
	  
	 // Imp.InsertDataUsingChild();
	  
	  Imp.SelectTest();
  }
}
