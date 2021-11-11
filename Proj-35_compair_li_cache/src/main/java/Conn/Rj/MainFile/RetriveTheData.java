package Conn.Rj.MainFile;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.IdClassConfi;
import Conn.Rj.Entity.ProjectClassInfo;
import Conn.Rj.Utility.UtilityClassCall;

public class RetriveTheData
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
		    	//Create The Object Idclassconfi
		    	IdClassConfi idc=new IdClassConfi(101,102);
		    	
		    	//Create The Object projectclassinfo
		    	ProjectClassInfo proj=sec.get(ProjectClassInfo.class, idc);
		       
		    	//Chect The Data And retrive The Data
		    	if(proj==null)
		    		System.out.println("The Record Are Not Found");
		    	else
		    		System.out.println(proj);
		    }
		    catch (HibernateException he)
		    {
				he.printStackTrace();
			}
		    catch (Exception e)
		    {
		    	System.out.println("Retrive Time Problem Will Occure............!");
				 e.printStackTrace();
			}
	  }
}
