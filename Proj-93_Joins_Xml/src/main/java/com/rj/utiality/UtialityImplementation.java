package com.rj.utiality;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UtialityImplementation
{
	//Add The SessionFactory
   private static SessionFactory factory;
   //Add Teh Static Block And Implement The Code
   static
   {
	   try
	   {
	   //Active The Hibernate Framework
	   Configuration cgf=new Configuration();
	   //Add The Mordern BootStraping
	   //Add The StandardserviceRegisteryBuilder
	   StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
	   //Add The Standard Service egistery
	   StandardServiceRegistry registery=builder.configure("com/rj/cfgs/Hibernate.cfgs.xml").build();
	   //Build Sesion factory Hear
	   factory=cgf.buildSessionFactory(registery);
	   }
	   catch (HibernateException he)
	   {
		he.printStackTrace();
	   }
   }//Static
   
   //get the of SessionFactory object
   public static SessionFactory getSessionFactory()
   {
	   return factory;
   }
   
   //get The session Object
   public static Session getSession()
   {
	 Session sec=null;
	 if(factory!=null)
	 {
		 sec=factory.openSession();
	 }
	return sec;
   }
   
   //Close The SessionFactory
   public static void ClosesessionFactory()
   {
	   if(factory!=null)
		   factory.close();
   }
   
   //Close The session
   public static void CloseSession(Session sec)
   {
	   if(sec!=null)
	       sec.close();
   }
}//class
