package Conn.Rj.Mian;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Conn.Rj.Entity.TimeStampingOperacation;
import Conn.Rj.Utilty.UtilityClassCall;

public class UpdateMainClass 
{
	
   public static void main(String[] args)
   {
		//Craete The Sessionfactort object
		SessionFactory factory=UtilityClassCall.getSessionFactory();
		
		//create the session object
		Session sec=UtilityClassCall.getSession();
		
		//Craet The tranjaction
		Transaction tx=null;
		
		
	  //Crae The java-9 try resource
	   try(
			   //Se The Object SessionFactory And Session
			   factory;
			   sec
			   )
	   {
		     //Creat the Value set Data Object
		   TimeStampingOperacation ope=sec.get(TimeStampingOperacation.class, 101);
		   //Set The Value Update
		   ope.setGender("SeBc");
		   //Update The Data
		   sec.update(ope);
		   //commit The Data In the Sql
		   tx=sec.beginTransaction();
		   tx.commit();
		   System.out.println("The Data Has Been Sucssfully Updated..........!");
		   
		   System.out.println("The Update Data"+ope.getLastUpdate());
		   System.out.println();
		   System.out.println("The Data Are:----->   "+ope.getUpdationcount()+"     Time");
	   }
	   catch (HibernateException he)
	   {
		   if(tx!=null &&  tx.getStatus()!=null && tx.getRollbackOnly())
			   tx.rollback();
		   System.out.println("The Data Has Been Not Modified");
		    he.printStackTrace();
	   }
	   catch (Exception e)
	   {
		   System.out.println("The Object Input Are Not Properly Check..........!");
		   e.printStackTrace();
	   }
   }
}
