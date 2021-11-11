package Conn.Rj.MainClasas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClass;

public class CommitOpe_MainClass 
{
    public static void main(String[] args)
    {
	  //Create A sessioFactory Object
    	SessionFactory factory=UtillImplementClass.getSessionFactory();
    
    	//Ceate A Session Object
    	Session sec=UtillImplementClass.getSession();
    	
    	//Create A tranaction object
    	Transaction tx=null;
    	
    	try(
    			//Set The Objects
    			factory;
    			sec
    			)
    	{
    		//Create The settergetter class Object
    		SetterAndGetterMeyhod set=sec.get(SetterAndGetterMeyhod.class, 101005);
    		
    		//Set the product
    		set.setStatus("Avalable");
    		tx=sec.beginTransaction();
    		tx.commit();
    		System.out.println("The Record HasBeen Updated...............!");
    	}//try
    	catch (HibernateException he)
    	{
    		if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
    			tx.rollback();
    		System.out.println("The Record has Been Not Updated................!");
			he.printStackTrace();
		}
    	catch (Exception e)
    	{
    		System.out.println("Plz Contact The Devloper");
			e.printStackTrace();
			
		}
	}//main
}//class
