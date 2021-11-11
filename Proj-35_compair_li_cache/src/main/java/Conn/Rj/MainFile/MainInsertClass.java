package Conn.Rj.MainFile;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.IdClassConfi;
import Conn.Rj.Entity.ProjectClassInfo;
import Conn.Rj.Utility.UtilityClassCall;

public class MainInsertClass 
{
  public static void main(String[] args)
  {
	  //Create The SessionFactory Object
	    SessionFactory factory=UtilityClassCall.getSessionFactory();
	    
	    //Creat the Session Object
	    Session sec=UtilityClassCall.getSession();
	    
	    //Creat The Tranction
	    Transaction tx=null;
	    
	    try(
	    		factory;
	    		sec
	    		)
	    {
	    	 
	    }
	    catch (HibernateException he)
	    {
	    	if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
	    		tx.rollback();
	    	System.out.println("The Data Has Been Rollback...........!");
			 he.printStackTrace();
		}
	    catch (Exception e)
	    {
	    	System.out.println("Object Inseting Time poblem Occure....!");
			e.printStackTrace();
		}
  }
}
