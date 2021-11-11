package com.rj.main;

import com.rj.Dao.IPersionDetails;
import com.rj.Dao.PersionIDetails_Impl;

public class TestTheCode 
{
  public static void main(String[] args)
  {
	  IPersionDetails Ip=new PersionIDetails_Impl();
	  //Ip.InsertData();
	  Ip.SelectData();
	 //Ip.DeleteOneChildOfParent();
  }
}
