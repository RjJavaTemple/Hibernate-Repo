package Conn.Rj.Mian;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.TimeStampingOperacation;
import Conn.Rj.Utilty.UtilityClassCall;

public class MianClass 
{
  public static void main(String[] args)
  {
	  //Create the sessionfactory
	  SessionFactory factory=UtilityClassCall.getSessionFactory();
	  
	  //Create The Session
	  Session sec=UtilityClassCall.getSession();
	  
	  //Create The tranction
	  Transaction tx=null;
	  try(factory;sec)
	  {
		    tx=sec.beginTransaction();
		   TimeStampingOperacation ope=sec.get(TimeStampingOperacation.class, 101);
		   ope.setAddress("cuttack");
		   sec.update(ope);
		   //Commit The Object
		   tx.commit();
		   System.out.println("the Object Are Saved Sucessfully..!");
	  }
	  catch (HibernateException he)
	  {
		  System.out.println("The Object Are Not Saved");
		  if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			  tx.rollback();
		  he.printStackTrace();
	  } 
	  catch (Exception e)
	  {
		  e.printStackTrace();
	  }
  }
}
