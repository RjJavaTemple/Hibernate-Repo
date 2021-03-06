package com.rj.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rj.entity.Person;
import com.rj.utiality.UtialityImplitation;

import net.sf.ehcache.util.ProductInfo;

public class ClientTestApp
{
  public static void main(String[] args)
  {
	 //Create The SessionFactory Object
	  SessionFactory factory=UtialityImplitation.getSessionFactory();
	  //Create The Session Obj
	  Session sec=UtialityImplitation.getSession();
	  try(sec;factory)
	  {
		  //Create Query
		  Query queru=sec.createQuery("from Person");
		  queru.setCacheable(true);
		  queru.setCacheRegion("region1");
		  List<Person> list=queru.getResultList();
		   list.forEach(Prod1->{
			   System.out.println("First Data");
			   System.out.println(Prod1);
		   });
		  
		   //Create 2nd List Object
		   List<Person> list2=queru.getResultList();
		   list2.forEach(Prod2->{
			   System.out.println("Second Data");
			   System.out.println(Prod2);
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
