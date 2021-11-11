package Conn.Rj.MainClasas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClass;

public class DeleteObjectApproch2 
{
  public static void main(String[] args)
  {
	  //Set The factory And Session Object..
	 SessionFactory factory=UtillImplementClass.getSessionFactory();
	 Session sec=UtillImplementClass.getSession();
	 Transaction tx=null;
	 try(
			 factory;
			 sec
			 )
	 {
		 SetterAndGetterMeyhod pro=sec.get(SetterAndGetterMeyhod.class, 101002);
		 if(pro==null)
		 {
			 System.out.println("The Data Has Been Not Deleted.......!");
		 }
		 else
		 {
			 tx=sec.beginTransaction();
			 sec.delete(pro);
			 tx.commit();
			 System.out.println("The Record Are SucessFully Deleted......!");
		 }
	 }//try
	 catch (HibernateException he)
	 {
		he.printStackTrace();
		if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			tx.rollback();
		System.out.println("The Exception Will Arrise Contact With Devloper My No ::7008943470");
	 }
	 catch (Exception e)
	 {
		e.printStackTrace();
	 }
  }
}
