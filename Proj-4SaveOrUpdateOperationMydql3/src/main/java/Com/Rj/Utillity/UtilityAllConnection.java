package Com.Rj.Utillity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilityAllConnection 
{
   private static SessionFactory factory;
   static
   {
	   try
	   {
		   //Active The Hibermnet Framework
		   Configuration cfg=new Configuration();
		   
		   //Link the Xml File The Confoiguracation
		   cfg.configure("Com/Rj/Cfgs/Hibernete.xml");
		   
		   //Build SessionFactory
		   factory=cfg.buildSessionFactory();
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
   
   public static SessionFactory getSessionFactory()
   {
	   return factory;
   }
   
   public static Session getSession()
   {
	   Session sec=null;
	   if(factory!=null)
	   {
		   sec=factory.openSession();
	   }
	   return sec;
   }
   
   
   public static void closeSessionFactory()
   {
	   if(factory!=null)
		   factory.close();
   }
   
   public static void closeSession(Session sec)
   {
	   if(sec!=null)
	   sec.close();
   }
}//class
