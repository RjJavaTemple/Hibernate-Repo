package Conn.Rj.UtillStatic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UtillImplementClass
{
	private static SessionFactory factory;
	   static
	   {
		   try
		   {
			   //Lode the prpoperty object
			  Properties prop=new Properties();
			   //Lode the input file stream
			   InputStream is=new FileInputStream("src/Conn/commons/file/info.properties");
			   prop.load(is);
			   
			   //Active the Hb Framework
			   Configuration cfg=new  Configuration();
	
			   cfg.addFile("src/Conn/rj/Entity/product.hbm.xml");
			  	
               cfg.setProperties(prop);
			   
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
