package Conn.Rj.Thread;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetAndGetClass;
import Conn.Rj.Utility.UtilityStaticClass;

public class ThreadClass implements Runnable
{

	@Override
	public void run()
    {
	    	System.out.println("The Thread Name:--"+Thread.currentThread().getName());
	    	try
	    	{
	    		if(Thread.currentThread().getName().equalsIgnoreCase("thread2"))
	    		{
	    			Thread.sleep(40000);
	    		}
	    	}
	    	catch (Exception e)
    		{
				e.printStackTrace();
			}
	    	
	    	Transaction tx=null;
	    	Session sec=UtilityStaticClass.getSession();
	    	
	    	SetAndGetClass set=new SetAndGetClass();
	    	set.setPname("Table-2");
	    	set.setPrice(57.90);
	    	set.setQty(41.7);
	    	set.setStatus("Avl-Soon");
	    	try(sec)
	    	{
	    		 tx=sec.beginTransaction();
	    		 int idval=(int)sec.save(set);
	    		 System.out.println("The Id Value Are:--"+idval);
	    		 tx.commit();
	    	}
	    	catch (HibernateException he)
	    	{
	    		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
	    			tx.rollback();
	    		System.out.println("Object Insert Time Problem");
				he.printStackTrace();
			}
	    	catch (Exception e)
	    	{
	    		System.out.println("Raise Un-Known Exception......!");
				e.printStackTrace();
			}
	}
    
}
