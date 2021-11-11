package Conn.Rj.UtillStatic;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtillImplementClassMySql
{
	private static SessionFactory factory;
	   static
	   {
		   try
		   {
			   //Active the Hb Framework
			   Configuration cfg=new  Configuration();
			   
			   //Link The configeru File
			   cfg.configure("Conn/Rj/cfgs/Hibernet.Mysql.xml");
			   
			   //Build Session factory
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
