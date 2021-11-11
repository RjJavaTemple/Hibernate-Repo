package com.rj.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rj.entity.StudentDetails;
import com.rj.utiality.UtialityImplementation;

public class RetriveData
{
  public static void main(String[] args) 
  {
	  //Create The SessionFactory Object
	  SessionFactory factory=UtialityImplementation.getSessionFactory();
	  //Create The Session Object
	  Session sec=UtialityImplementation.getSession();
	  
	  try(factory;
			  sec
			  )
	  {
		  //Retrive The Data Using The Query Object
		  Query query=sec.createQuery("from StudentDetails");
		  //Using The List
		  List<StudentDetails> list=query.getResultList();
		  //Using Lambda
		  list.forEach(data->{
			  System.out.println(data);
		  });
	  }
	 catch (HibernateException he)
	  {
		 he.printStackTrace();
	  }
	  catch (Exception e)
	  {
		  e.printStackTrace();
	  }
  }
}
