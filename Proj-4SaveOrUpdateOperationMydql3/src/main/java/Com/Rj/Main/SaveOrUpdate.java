package Com.Rj.Main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Com.Rj.Entity.Set_Value_SetterAndGetter;
import Com.Rj.Utillity.UtilityAllConnection;

public class SaveOrUpdate 
{
  public static void main(String[] args)
  {
	  //Create The Hibernet Object.........
	  SessionFactory factory=UtilityAllConnection.getSessionFactory();
	  Session sec=UtilityAllConnection.getSession();
	  Transaction tx=null;
	  try(
			  factory;
			  sec
			  )
	  {
		  //Set The Value In The Query...
		  Set_Value_SetterAndGetter set=sec.get(Set_Value_SetterAndGetter.class, 102);
		  if(sec==null)
			  System.out.println("The Record Is Not Found............!");
		  else
		  {
			  tx=sec.beginTransaction();
			  set.setName("Ranjan");
			  set.setAddress("Ckl");
			  set.setMark(620.0);
			  set.setAvg(11.02);
			  set.setGrade('C');
			  sec.saveOrUpdate(set);
			  tx.commit();
			  System.out.println("The Record Has Been Enter And Update Sucessfully.........................!");
		  }
	  }//try
	  catch (HibernateException he)
	  {
		  if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			  tx.rollback();
		  System.out.println("Plz Contact Your Devloper.............");
		 he.printStackTrace();
	  }
	  catch (Exception e)
	  {
		 e.printStackTrace();
		 System.out.println("Plz Contact Your Devloper.....");
	  }
  }//class
}//class
