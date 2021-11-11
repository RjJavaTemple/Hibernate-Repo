package Conn.Rj.Utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtialityImplementation
{
      private static SessionFactory factroy;
      static
      {
    	  //This is modern BootStraping......
    	  try
    	  {
    		   //Create The Cfg To Active The HibernateFaramework
    		  Configuration cfg=new Configuration();
    		  
    		  cfg.configure("Conn/Rj/Cfgs/Hibernate.cfgs.xml");
    		   
    		   //Create The Session Factory
    		  factroy=cfg.buildSessionFactory();
    	  }
    	  //Using Known-exception
    	  catch (HibernateException he)
    	  {
			  he.printStackTrace();
		  }
    	  //Using UnKnown-Exception
    	  catch (Exception e)
    	  {
			   e.printStackTrace();
		  }
      }//Static
      
      //Create The GetterMethod SessionFactory
      public static SessionFactory getSessionFactory()
      {
    	  return factroy;
      }
      
      //Create The Sessin In Get Method
      public static Session getSession()
      {
    	  Session sec=null;
    	  if(factroy!=null)
    	  {
    		  sec=factroy.openSession();
    	  }
    	  return sec;
      }
      
      //Close the sessionfactoryObject
      public static void closeSessionFactory()
      {
    	  if(factroy!=null)
    		  factroy.close();
      }
      
      //Close The Session Object
      public static void closeSession(Session sec)
      {
    	  if(sec!=null)
    	  {
    		  sec.close();
    	  }
      }
}//class