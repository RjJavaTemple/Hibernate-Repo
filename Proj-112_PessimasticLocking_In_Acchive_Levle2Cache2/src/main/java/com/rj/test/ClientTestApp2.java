package com.rj.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rj.entity.Person;
import com.rj.utiality.UtialityImplitation;

import net.sf.ehcache.util.ProductInfo;

public class ClientTestApp2
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
		Person Per=sec.get(Person.class, 1,LockMode.UPGRADE_NOWAIT);
		System.out.println(Per);
		Per.setSalary(320.0f);
		sec.saveOrUpdate(Per);
		tx.commit();
		System.out.println("The Object Are Update-2");
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
