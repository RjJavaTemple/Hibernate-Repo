package com.rj.test;

import com.rj.dao.MethhodInDao;
import com.rj.dao.MethodImplDao;
import com.rj.utiality.UtialityImplitation;

public class MianClient_App 
{
    public static void main(String[] args)
    {
	  //Lode The Object 
    	MethhodInDao Dao=new MethodImplDao();
    	//Dao.InsertOperacation();
    	Dao.UpdateSalary(101004, 10);
    	
    	//Close The SessionFactory
    	UtialityImplitation.CloseSessionFactory();
	}
}
