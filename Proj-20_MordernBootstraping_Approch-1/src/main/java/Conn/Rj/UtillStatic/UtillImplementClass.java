package Conn.Rj.UtillStatic;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UtillImplementClass
{
	private static SessionFactory factory;
	   static
	   {
		   try
		   {
			   //Active the Hb Framework
			   Configuration cfg=new  Configuration();
			   
			   //Link The configure File
			   cfg.configure("Conn/Rj/cfgs/Hibernet.xml");
			   cfg.addResource("Conn/Rj/Entity/product.hbm.xml");	
			   
			   //Create the ServiceRegistry
			   StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			   
			   //create a service Registry
			   StandardServiceRegistry registery=builder.applySettings(cfg.getProperties()).build();
			   
			   //Build Session factory
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
	   }//Static
		   public static SessionFactory  getSessionFactory()
		   {
			   if(factory!=null)
				   return factory;
			   else
				   throw new RuntimeException("Invalid Session Factory Creation");
		   }
		   
		   public static Session getSession()
		   {
			   Session sec=null;
			   if(factory!=null)
				   sec=factory.openSession();
			   return sec;
		   }
		   public static void closeSession(Session sec)
		   {
			   if(sec!=null)
				   sec.close();
		   }
		   public static void closeSessionFactory()
		   {
			   if(factory!=null)
				   factory.close();
		   }
}
