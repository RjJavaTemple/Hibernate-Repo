package Conn.Rj.MainClasas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClass;

public class DeleteDataApproch1 
{
  public static void main(String[] args)
  {
	  //Call the Utilclass To Sessionfactory and session
	  SessionFactory factory=UtillImplementClass.getSessionFactory();
	  Session sec=UtillImplementClass.getSession();
	  Transaction tx=null;
	try(factory;sec)
	{
	       //Set The Vcalue What Evwe UI cdeleted
		 SetterAndGetterMeyhod pro=new SetterAndGetterMeyhod();
		  pro.setPid(101010);
		  sec.delete(pro);
		 tx=sec.beginTransaction();
		 tx.commit();
		 System.out.println("The Data Has Been Deleted........!");
	}
	catch (HibernateException he)
	{
		he.printStackTrace();
		if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			tx.rollback();
		System.out.println("The Data has Been Not Deleted...");
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
  }
}
