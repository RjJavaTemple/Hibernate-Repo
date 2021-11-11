package Com.Rj.Clint;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class MainClintApp 
{
  public static void main(String[] args)
  {
	  //Create The SessionFactory Object
	 SessionFactory factory=UtialityImplementation.getSessionFactory();
	 //Create The Session Object
	 Session sec=UtialityImplementation.getSession();
	Transaction tx=null;
	 try(
			 factory;
			 sec
			 )
	 {
		 //Create The Object Class
		   SetAndGetImp set=new SetAndGetImp();
		   //set The Data In The Table
			set.setActorName("Rashmi-1");
			set.setActorAddress("mum(MUM)");
			set.setActorGender("male(M)");
			set.setActorColor("whiteBlack");
			set.setActorSalary(22000.0);
			set.setActorCurrentFilm("Kach-Kack-3");
		   
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
		 
