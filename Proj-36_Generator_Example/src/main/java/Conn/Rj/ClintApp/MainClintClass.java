package Conn.Rj.ClintApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetAndGetClass;
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
		    //Create The Object Class
		   SetAndGetClass set=new SetAndGetClass();
		   
		   //set The Data In The Table
		   set.setPid(1);
		   set.setPname("Ranjan");
		   set.setPrice(90.00);
		   set.setQty(3.08);
		   set.setStatus("Avalable");
		   
		   //Save the Object
		   sec.save(set);
		   
		   //Create The Begin Truncation
		   tx=sec.beginTransaction();
		   //Commit The Code...
		   tx.commit();
		   System.out.println("The Object Are Saved Sucessfully.............!");
	   }
	   catch (HibernateException he)
	   {
		   if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			   tx.rollback();
		   System.out.println("The Object Are Return The Back Java App........!");
		  he.printStackTrace();
	   }
	   catch (Exception e)
	   {
		   System.out.println("The Object Are Return");
		   System.out.println("Object Input Time Problem...!");
		   e.printStackTrace();
	   }
   }
}
