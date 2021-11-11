package Conn.Rj.Utilit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UtilityImplement 
{
   private static final SessionFactory factory;
   static
   {
	   //Active The HB Framework
	   Configuration cfg=new Configuration();
	   
	   //Using The Morden Botstraping
	     //Create The StandardServiceRegisteryBuilder Object
	   StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
	   
	 //Create The StandardServiceRegistery Object
	   StandardServiceRegistry registery=builder.configure("Conn/Rj/cfg/Hibernate.cfg.xml").build();
	   
	   //Create The Opensession
	   factory=cfg.buildSessionFactory(registery);
   }//static
   
   //Get The SessionFactory
   public static SessionFactory getSessionFactory()
   {
	   return factory;
   }
 
   //Get The Session
   public static Session getSession()
   {
	   Session sec=null;
	   if(factory!=null)
	   {
		  sec=factory.openSession();
	   }
	   return sec;
   }
   
   //close The SessionFactory
   public static void CloseSessionFactory()
   {
	   if(factory!=null)
		   factory.close();
   }
   
   //Clos The Session
   public static void CloseSession(Session sec)
   {
	  if(sec!=null)
		  sec.close();
   }
}
