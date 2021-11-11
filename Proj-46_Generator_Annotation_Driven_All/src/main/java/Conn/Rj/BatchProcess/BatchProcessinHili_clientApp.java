package Conn.Rj.BatchProcess;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetAndGetClass;
import Conn.Rj.Utility.UtialityImplementation;

public class BatchProcessinHili_clientApp
{
    public static void main(String[] args)
    {
    	//Create The Session object
    	SessionFactory factory=UtialityImplementation.getSessionFactory();
    	//Create The session Object
    	Session sec=UtialityImplementation.getSession();
    	//Create The Tranction Object
    	Transaction tx=null;
	    try
	    {
	    	for(int i=0;i<=10;i++)
	    	{
	    	 SetAndGetClass set=new SetAndGetClass();
	    	 set.setStudentName("Rashmi-2");
	    	 set.setStudentAddress("Mirzapur-1");
	    	 set.setStudentFullMark(66.00);
	    	 set.setStudentSection('A');
	    	 int idval=(int) sec.save(set);
	    	 System.out.println("The Object Are Saved");
	    	 System.out.println("Saved Are"+idval+" Time");
	    	}
	    	tx=sec.beginTransaction();
	    	tx.commit();
	    }
	    catch (HibernateException se)
	    {
	    	if(tx!=null)
	    		tx.rollback();
	    	System.out.println("The Object Input Time Problem Occure.....!");
			  se.printStackTrace();
		}
	    catch (Exception e)
	    {
			e.printStackTrace();
		}
	}
}
