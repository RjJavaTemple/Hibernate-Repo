package com.rj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rj.entity.Person;
import com.rj.utiality.UtialityImplitation;

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
		  //Lode The Object
		  Person Per=sec.get(Person.class, 1);
		  System.out.println(Per);
		  Person Per1=sec.get(Person.class, 1);
		  System.out.println(Per1);
		  Person Per2=sec.get(Person.class, 1);
		  System.out.println(Per2);
		  sec.clear();
		  Person Per4=sec.get(Person.class, 1);
		  System.out.println(Per4);
		  sec.evict(Per4);
		  Person Per5=sec.get(Person.class, 1);
		  System.out.println(Per5);
		  System.out.println("The Java App Are Sleep");
		  sec.clear();
		  Thread.sleep(25000);
		  Person Per6=sec.get(Person.class, 1);
		  System.out.println(Per6);
      }
	  catch (Exception e)
	  {
		  e.printStackTrace();  
	  }
  }
}
