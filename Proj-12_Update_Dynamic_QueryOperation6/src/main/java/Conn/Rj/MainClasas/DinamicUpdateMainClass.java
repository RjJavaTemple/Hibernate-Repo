package Conn.Rj.MainClasas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClass;

public class DinamicUpdateMainClass 
{
  public static void main(String[] args)
  {
	  //Create SessionFactory The object 
	  SessionFactory factory=UtillImplementClass.getSessionFactory();
	  
	  //Create Session Object
	  Session sec=UtillImplementClass.getSession();
	  
	  //Create Tranjaction Object
	  Transaction tx=null;
	  
	  //Using Try With Resourct Java9
	  try(
			  //Set The All Object Here
			  factory;
			  sec
			  )
	  {
		  //Set The Data in the Table
		  SetterAndGetterMeyhod se=new SetterAndGetterMeyhod();
		  
		  //Se the All Data in the table
		  se.setPid(104);
		  se.setPname("Table3");
		  se.setPrice(323.00);
		  se.setQty(110.0);
		  se.setStatus("Avalable");
		  
		  //Set The Tranction
		  tx=sec.beginTransaction();
		  
		  //Cast  the Value
		  int pid=(int) sec.save(se);
		  tx.commit();
		  System.out.println("The Record Are Update Susessfully..........!");
	  }
	  //Using known Exception
	  catch (HibernateException he)
	  {
		  if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			  tx.rollback();
		  System.out.println("The Record Are Not Update.........!");
		 he.printStackTrace();
	  }
	  //using un-known Exception
	  catch (Exception e)
	  {
		  System.out.println("Plz Contact Your Devloper.........!");
		 e.printStackTrace();
	  }
   }
}
