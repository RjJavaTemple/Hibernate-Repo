package Conn.Rj.ClintApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetAndGetData;
import Conn.Rj.Utility.UtilityStaticClass;

public class MainClintClass
{
   public static void main(String[] args)
   {
	   //Create the Object Factory
	   SessionFactory factory=UtilityStaticClass.getSessionFactory();
	   
	   //Create The session object
	   Session sec=UtilityStaticClass.getSession();
	   
	   //Create The Tranjaction
	   Transaction tx=null;
	   
	   try(
			   //Set The All object
			   factory;
			   sec
			   )
	   {
		   //Create tee setandget class object
		   SetAndGetData actor=new SetAndGetData(101001,"Ranjan","Hyd",7007843,"Hero");
		   Integer idval=(Integer) sec.save(actor);
		   System.out.println("The Object Will be Saved");
		   System.out.println("The Id Is:---->"+idval);
		   //Create the Tranjaction
		   tx=sec.beginTransaction();
		   tx.commit();
	   }
	   catch (HibernateException he)
	   {
		  he.printStackTrace();
	   }
	   catch (Exception e)
	   {
		   e.printStackTrace();
	   }
   }
}
