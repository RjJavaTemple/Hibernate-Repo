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
	Session sec=factory.openSession();
	Transaction tx=null;
	
	try(
			factory;
			sec
			)
	{
		//Set the value In the Class
		SetterAndGetterMeyhod se=sec.get(SetterAndGetterMeyhod.class, 101);
		if(se!=null)
		{
			System.out.println("The Record Are      \n");
			System.out.println("The Emp Id Is:---"+se.getPid());
			System.out.println("The Emp Name Is:---"+se.getPname());
			System.out.println("The Emp Price Is:---"+se.getPrice());
			System.out.println("The Emp Qty Is:---"+se.getQty());
			System.out.println("The Emp Status Is:---"+se.getStatus());
		}
		else
			System.out.println("The Record Are Not Found............!");
	}
	catch (HibernateException he)
	{
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
