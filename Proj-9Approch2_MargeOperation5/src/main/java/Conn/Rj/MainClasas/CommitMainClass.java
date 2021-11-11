package Conn.Rj.MainClasas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClass;

public class CommitMainClass 
{
   public static void main(String[] args)
   {
	   //create sessionfactory and session object
	   SessionFactory factory=UtillImplementClass.getSessionFactory();
	   
	   Session sec=UtillImplementClass.getSession();
	   
	   Transaction tx=null;
	  try(
			    factory;
			  sec
			  )
	  {
		  //Create The Product Object..
		  SetterAndGetterMeyhod set=sec.get(SetterAndGetterMeyhod.class, 1010011);
		  if(set==null)
			  System.out.println("Data has Been Not Update.........!");
		  else
		  {
			  
			  //Overcome The problem Use The marge Method............
			  set.setPname("Mobile");
			  set.setPrice(11500.00);
			  set.setStatus("Not-Avalable");
			  set.setQty(1.0);
			  tx=sec.beginTransaction();
			  tx.commit();
			  System.out.println("The Record Has Been Sucessfully Update................!");
		  }
	  }
	  catch (HibernateException he)
	  {
		  if( tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			  tx.rollback();
		  System.out.println("The Object Are Not Update  Plz Chect The Enter Data..");
		 he.printStackTrace();
	  }
	  catch (Exception e)
	  {
		  System.out.println("Plz Contact the Devloper");
		  e.printStackTrace();
	  }
   }
}
