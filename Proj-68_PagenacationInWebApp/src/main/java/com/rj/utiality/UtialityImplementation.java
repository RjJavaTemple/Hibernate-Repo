package com.rj.utiality;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UtialityImplementation 
{
	//Creatre The SessionFactory Object In The First
  private static SessionFactory factory;
  
  //Create The Static block Are Implement The 
  static
  {
	  //Active The Hibernate Framework
	  Configuration cfg=new Configuration();
	 
	  //Create The StandardServiceRegisteryBuilder
	  StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
	  
	  //Create The StandardServiceRegistery
	  StandardServiceRegistry registery=builder.configure("com/rj/cfgs/Hibernate.cfg.xml").build();
	  
	  //Open The Session Factofry
	  factory=cfg.buildSessionFactory(registery);
  }//static
  
  //Create The SessionFactoru GetMethod
  public static SessionFactory getSessionFactory()
  {
	  return factory;
  }
  
  //Create The Session GetMethod
  public static Session getSession()
  {
	  Session sec=null;
	  if(factory!=null)
	  {
		  sec=factory.openSession();
	  }
	  return sec;
  }
  
  
  //Close The SessionFctory
  public static void CloseSessionFactory()
  {
	  if(factory!=null)
		  factory.close();
  }
  
  //close The Session 
  public static void CloseSession(Session sec)
  {
	  if(sec!=null)
		  sec.close();
  }
}
