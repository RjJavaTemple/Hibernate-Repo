package Conn.Rj.MainClasas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClass;

public class RefreshMainFile 
{
	public static void main(String[] args)
	{
    //Create A Sessiofactory object
	SessionFactory factory=UtillImplementClass.getSessionFactory();
	
	//Create A session Object
	Session sec=UtillImplementClass.getSession();
	
	//Create A tranaction
	Transaction tx=null;
	
	try(
			factory;
			sec
			)
	{
		   //Create A Settergettermethod
		SetterAndGetterMeyhod set=sec.get(SetterAndGetterMeyhod.class,101012);
		System.out.println("the 1St Prod Value Is");
		System.out.println(set);
		
		//Execute the Refresh Method...
		System.out.println("The Compiler Will Be Sleep At 140 sec");
		Thread.sleep(40000);
		System.out.println("After Tjhe Refresh Method The Product Value is:--");
		sec.refresh(set);
		System.out.println(set);
	}
	catch (HibernateException se)
	{
		System.out.println("The Record Has Been Not Updated........!");
		se.printStackTrace();
	}
	catch (Exception e)
	{
		System.out.println("Plz Contact The Devloper.....!");
		e.printStackTrace();
		
	}
}
}
