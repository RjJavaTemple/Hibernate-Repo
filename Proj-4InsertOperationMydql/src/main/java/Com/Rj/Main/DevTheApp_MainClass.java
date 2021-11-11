package Com.Rj.Main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Com.Rj.Entity.Set_Value_SetterAndGetter;
import Com.Rj.Utillity.UtilityAllConnection;

public class DevTheApp_MainClass 
{
   public static void main(String[] args)
   {
	   //Call The Utility Class Method..
	  SessionFactory factory=UtilityAllConnection.getSessionFactory();
	  Session sec=UtilityAllConnection.getSession();
	  Transaction tx=null;
	  try(
			  factory;
			  sec
			  )
	  {
		  //Call The Setter and Getter Class
		  Set_Value_SetterAndGetter set=new Set_Value_SetterAndGetter();
         
		  //Set Th Value
		  set.setSno(102);
		  set.setName("Ranjan");
		  set.setAddress("Mirzapur");
		  set.setMark(360.33);
		  set.setAvg(60.00);
		  set.setGrade('A');
		  sec.save(set);
		  tx=sec.beginTransaction();
		  tx.commit();
		  System.out.println("The Has Been Saved Sucessfully");
	  }//try
	  catch (HibernateException he)
	  {
		  if(tx!=null)
			  tx.rollback();
		  System.out.println("The Data Has Been Not Enter....");
		he.printStackTrace();
	  }
	  catch (Exception e)
	  {
		  System.out.println("Plz ConTact Your Devloper..");
		e.printStackTrace();
	  }
   }//main
}//class
