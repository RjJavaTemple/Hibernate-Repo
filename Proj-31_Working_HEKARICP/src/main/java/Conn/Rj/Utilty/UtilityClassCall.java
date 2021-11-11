package Conn.Rj.Utilty;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UtilityClassCall 
{
  private static SessionFactory factory;
  static
  {
	  try
	  {
		  //Active Hibenate
		  Configuration cfg=new Configuration();
		  
		  
		  //Create Standardregisteryservicebulide
		  StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		  
		  //Create The Standard Service Registery
		  StandardServiceRegistry registery=builder.configure("Conn/Rj/Cfgs/Hibernate.cfgs.xml").build();

		  //buils session Factory
		  factory=cfg.buildSessionFactory(registery);
		   
	  }
	  catch (HibernateException he)
	  {
		  he.printStackTrace();
	  }
	  catch (Exception e)
	  {
		   e.printStackTrace();
	  }
  }//static
  
  //GetSessionfactory
  public static SessionFactory getSessionFactory()
  {
	  return factory;
  }
  
  //getsession
  public static Session getSession()
  {
	  Session sec=null;
	  if(factory!=null)
	  {
		sec=factory.openSession();
	  }
	  return sec;
  }
  
  //Close The Sessionfactory
   public static void closeSessionFactort() 
   {
	   if(factory!=null)
		   factory.close();
   }
   
   //close the session
   public static void closeSession(Session sec)
   {
   if(sec!=null)
	   sec.close();
   }
}//class
