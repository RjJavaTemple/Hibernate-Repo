package Conn.Rj.ClintApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetAndGetFileAnnotation;
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
		   //Create The tranction
		      tx=sec.beginTransaction();
		      //Create The SetandDeter class object
              SetAndGetFileAnnotation set=new SetAndGetFileAnnotation(7008943L, true, "CKL", "Dil_Dil");
              //save The object
              sec.save(set);
              //commit The Data
              tx.commit();
              System.out.println("The Objct Are Saved............!");
	   }
	   catch (HibernateException he)
	   {
		   if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			   tx.rollback();
		   System.out.println("Object Are Not Saved Problem Input The Object...!");
		  he.printStackTrace();
	   }
	   catch (Exception e)
	   {
		   e.printStackTrace();
	   }
   }
}
