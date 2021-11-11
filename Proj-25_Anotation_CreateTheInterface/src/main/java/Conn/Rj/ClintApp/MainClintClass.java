package Conn.Rj.ClintApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.ArtInterface;
import Conn.Rj.Entity.SetAndGetData;
import Conn.Rj.Utility.UtilityStaticClass;

public class MainClintClass
{
   public static void main(String[] args)
   {
	   //Create the Object Factory
	   SessionFactory factory=UtilityStaticClass.getSessionFactory();
	   
	   //Create The session object
	   Session sec=UtilityStaticClass.getSession();
	   
	   //Create The Tranjaction
	   Transaction tx=null;
	   
	   try(
			   //Set The All object
			   factory;
			   sec
			   )
	   {
//		   tx=sec.beginTransaction();
//		   //Create tee setandget class object
//		  SetAndGetData data=new SetAndGetData(101,"Ranjan","HYD",7008943,"Hero");
//		  int idvalue=(int) sec.save(data);
//		  System.out.println("The Object Are Saved.........!");
//		  System.out.println("The IdValue Are:--"+idvalue);
//		  tx.commit();
		   
		   
		   ArtInterface art=sec.load(ArtInterface.class, 101002);
		   System.out.println(art);
		   
	   }
	   catch (HibernateException he)
	   {
		   if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			   tx.rollback();
		   System.out.println("Object Are Not Saved Problem Input The Object...!");
		  he.printStackTrace();
	   }
	   catch (Exception e)
	   {
		   e.printStackTrace();
	   }
   }
}
