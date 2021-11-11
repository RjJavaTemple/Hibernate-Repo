package Com.Rj.Main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Com.Rj.Entity.Set_Value_SetterAndGetter;
import Com.Rj.Utillity.UtilityAllConnection;

public class UpdateMainClass 
{
  public static void main(String[] args)
  {
	  //Create All Utility Class Object.....
	   SessionFactory factory=UtilityAllConnection.getSessionFactory();
	   Session sec=UtilityAllConnection.getSession();
	   Transaction tx=null;
	   try(
			   factory;
			   sec
			   )
	   {
		   //Set The Data.....
		   Set_Value_SetterAndGetter set=sec.get(Set_Value_SetterAndGetter.class, 101);
		   if(set==null)
			   System.out.println("The Recore Are Not Avalable.......!");
		   else
		   {
			   tx=sec.beginTransaction();
			   set.setMark(766.0);
			   set.setName("Mama");
			   set.setAvg(66.90);
			   set.setAddress("HYD");
			   sec.update(set);
			   tx.commit();
			   System.out.println("The Record Are  Update Sucessfully..............!");
		   }
	   }
	   catch (HibernateException he)
	   {
	      he.printStackTrace();
	      if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
	    	  tx.rollback();
	      System.out.println("Plz Contact By The Devloper.........!");
	  }
	   catch (Exception e)
	   {
		 e.printStackTrace();
		 System.out.println("Plz Contact By The Devloper.........!");
	   }
  }//mian
}//class
