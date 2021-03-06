package com.rj.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
	  //Add The Tranction
	  Transaction tx=null;
	  try(sec;factory)
	  {
		tx=sec.beginTransaction();
		//Lode The Object
		Person Per=sec.get(Person.class, 1);
		System.out.println(Per);
		Per.setSalary(310.0f);
		sec.saveOrUpdate(Per);
		System.out.println("The App Sleep");
		Thread.sleep(30000);
		tx.commit();
		System.out.println("The Object Are Update-1");
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
