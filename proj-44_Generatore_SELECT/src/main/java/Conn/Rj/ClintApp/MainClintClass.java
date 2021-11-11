package Conn.Rj.ClintApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetAndGetClass;
import Conn.Rj.Utility.UtialityImplementation;

public class MainClintClass
{
   public static void main(String[] args)
   {
	   //Create the Object Factory
	   SessionFactory factory=UtialityImplementation.getSessionFactory();
	   
	   //Create The session object
	   Session sec=UtialityImplementation.getSession();
	   
	   //Create The Tranjaction
	   Transaction tx=null;
	   
	   try(factory;sec)
	   {
		    //Create The Object Class
		   SetAndGetClass set=new SetAndGetClass();
		   //set The Data In The Table
			set.setStudentName("Ranjan");
			set.setStudentAddress("Ckl");
			set.setStdentAvrage(53.0);
			set.setStudentFullMark(600.00);
			set.setStudentSection('A');
		   
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
			   tx.rollback();
		   System.out.println("The Object Are Return The Back Java App........!");//ID_GEN_TERGER
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
