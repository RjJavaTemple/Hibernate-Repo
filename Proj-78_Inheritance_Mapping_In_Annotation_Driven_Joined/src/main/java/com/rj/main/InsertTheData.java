package com.rj.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rj.entity.Coustmor;
import com.rj.entity.Employee;
import com.rj.entity.Persion;
import com.rj.utiality.UtialityImplementation;

public class InsertTheData
{
  public static void main(String[] args)
  {
	//Create The SessionFactory Object
	  SessionFactory factory=UtialityImplementation.getSessionFactory();
	  //Create The Session
	  Session sec=UtialityImplementation.geSession();
	  //Create The Tranctio  Object
	  Transaction tx=null;
	  try(factory;
			  sec
			  )
	  {
		  //Add The Tranction Hear 
		  tx=sec.beginTransaction();
		  //Create The Persion Object
		  Persion per=new Persion();
		  //set The Persion Data
		  per.setName("Ranjan");
		  per.setAddress("Chandikhole");
		  
		  //Create The Employee Object
		  Employee emp=new Employee();
		  //Set The Data In The Employee
		  emp.setName("Rashmi-1");
		  emp.setAddress("Mirzapur");
		  emp.setDept("Mca");
		  emp.setDegs("Junier-Devloper");
		  emp.setSalary(10000.0);
		  
		  //Create The Coustomer Object
		  Coustmor cos=new Coustmor();
		  //Set The Data IN The Coustromer 
		  cos.setName("Chinky");
		  cos.setAddress("Bari");
		  cos.setBillAmount(2000.0);
		  cos.setPaymentType("Atm");
		  
		  //Save The All Object Hear
		  sec.saveOrUpdate(per);
		  sec.saveOrUpdate(cos);
		  sec.saveOrUpdate(emp);
		  
		  //Commit The Data In The Db Table
		  tx.commit();
		  System.out.println("Ther Data Are Saved Suessfully............!");
	  }
	  catch (HibernateException he)
	  {
		he.printStackTrace();
		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
			tx.rollback();
		System.out.println("The Data Input Time Problem Occure");
	}
	  catch (Exception e)
	  {
		e.printStackTrace();
		System.out.println("Plz Contact Your Devloper");
	  }
  }
}
