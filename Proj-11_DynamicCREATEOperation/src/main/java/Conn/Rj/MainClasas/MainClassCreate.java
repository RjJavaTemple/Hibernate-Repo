package Conn.Rj.MainClasas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClass;

public class MainClassCreate 
{
	public static void main(String[] args) 
	{
   //Create the Object
	SessionFactory factory=UtillImplementClass.getSessionFactory();
	Session sec=UtillImplementClass.getSession();
	Transaction tx=null;
	
	try(
			factory;
			sec
			)
	{
		//Set the value In the Class
		SetterAndGetterMeyhod set=new SetterAndGetterMeyhod();
		set.setPid(101);
		set.setPname("Amol");
	    set.setPrice(333.00);
	    set.setQty(33.0);
	    set.setStatus("Ava");
	   
	    tx=sec.beginTransaction();
	   
	    int idval=(int) sec.save(set);
	    tx.commit();
	    System.out.println("The Record Are Been Updated..............!");
	}
	catch (HibernateException he)
	{
		if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			tx.rollback();
		System.out.println("The Record Not Been Update");
		System.out.println("Contact The Dvloper.................!");
		he.printStackTrace();
	}
	catch (Exception e)
	{
		System.out.println("Contact The Devloper........!");
		e.printStackTrace();
	}
	}//main
}//class
