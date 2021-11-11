package Conn.Rj.Utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UtilityStaticClass
{
  private static SessionFactory factory;
    static
    {
    	try
    	{
    		//Active The Hb Framework
    		Configuration cfg=new Configuration();
    		
    		//Creat The Regesterybulider
    		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
    		
    		//Create standara service registery
    		StandardServiceRegistry registery=builder.configure("Conn/Rj/Cfgs/Hibernate.cfg.xml").build();
    		
    		//Create Session factory
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
    
      //Set The GetSessionFactory
      public static SessionFactory getSessionFactory()
      {
    	  return factory;
      }
      
      //Set The GetSession
      public static Session getSession()
      {
    	  Session sec=null;
    	  if(factory!=null)
    	  {
    		  sec=factory.openSession();
    	  }
    	    return sec;
      }
      
      //Close thr Factory
      public static void closeSessionFactory()
      {
    	  if(factory!=null)
    		  factory.close();
      }
      
      //Close The Session
      public static void closeSession(Session sec)
      {
    	  if(sec!=null)
    	  {
    		  sec.close();
    	  }
      }
}//class
