package MYSQL.RJ.Utlity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UtialityImplemetation 
{
   private static SessionFactory factory;
   static
   {
	   try
	   {
	   //Create The Configuration Object
	   Configuration cfg=new Configuration();
	   
	   //Create The StandardServiceRegisesteryBuilder object
	    StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
	    
	    //create the standard service register
	     StandardServiceRegistry registery=builder.configure("MYSQL/RJ/Cfgs/Hibernet.cfg.xml").build();
	     
	     //Open The Session Factory
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
   
   //Set the SessionFactory
    public static SessionFactory getSessionFactory()
    {
    	return factory;
    }
    
    //Set The session
    public static Session getSession()
    {
    	Session sec=null;
    	if(factory!=null)
    	{
    		sec=factory.openSession();
    	}
    	return sec;
    }
    
    //close The Sessionfactory
     public static void closeSessionFactory()
     {
    	  if(factory!=null)
    		  factory.close();
     }
     
     //Close The Session
     public static void closeSession(Session sec)
     {
    	  if(sec!=null)
    		  sec.close();
     }
}
