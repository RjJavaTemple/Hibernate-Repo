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
		  SetterAndGetterMeyhod set=sec.get(SetterAndGetterMeyhod.class, 101011);
		  if(set==null)
			  System.out.println("The Recpord Are Not Found......!");
		  else
		  {
			 SetterAndGetterMeyhod set1=new SetterAndGetterMeyhod();
		  set1.setPname("Laptop");
		  set1.setPrice(30000.00);
		  set1.setStatus("Avalable");
		  
		  SetterAndGetterMeyhod set2=(SetterAndGetterMeyhod)sec.merge(set1);
		  tx=sec.beginTransaction();
		  tx.commit();
		  System.out.println("Object Arer Update SucessFully.........!");
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
