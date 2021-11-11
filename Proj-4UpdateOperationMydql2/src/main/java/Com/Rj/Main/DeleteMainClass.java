package Com.Rj.Main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Com.Rj.Entity.Set_Value_SetterAndGetter;
import Com.Rj.Utillity.UtilityAllConnection;

public class DeleteMainClass 
{
   public static void main(String[] args)
   {
	  //Create The Hibernet What Ever The Utill Class Object..... 
	    SessionFactory factory=UtilityAllConnection.getSessionFactory();
	    Session sec=UtilityAllConnection.getSession();
	    Transaction tx=null;
	    try(
	    		
	    		factory;
	    		sec
	    		)
	    {
	    	//Input The Data Here
	    	 Set_Value_SetterAndGetter set=sec.get(Set_Value_SetterAndGetter.class, 101);
	    	 if(set==null)
	    		 System.out.println("No Record found....Plz Check The Input Number.......!");
	    	 else
	    	 {
	    		 tx=sec.beginTransaction();
	    		 sec.delete(set);
	    		 tx.commit();
	    	 }
	    }
	    catch (HibernateException he)
	    {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
				tx.rollback();
			System.out.println("Plz Contact the Devlopere...");
		}
	    catch (Exception e)
	    {
			e.printStackTrace();
			System.out.println("Problem Arrise The Software Plz Contact The Devloper...");
		}
   }
}
