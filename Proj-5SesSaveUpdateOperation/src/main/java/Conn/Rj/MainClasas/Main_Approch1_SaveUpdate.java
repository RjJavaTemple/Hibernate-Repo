package Conn.Rj.MainClasas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClass;

public class Main_Approch1_SaveUpdate
{
   public static void main(String[] args)
   {
	  //Call the Utill Class Object
	   SessionFactory factory=UtillImplementClass.getSessionFactory();
	   Session sec=UtillImplementClass.getSession();
	   Transaction tx=null;
	   try(
			   factory;
			   sec
			   )
	   {
		   //Call The Set Geter Method
		   SetterAndGetterMeyhod pro=new SetterAndGetterMeyhod();
		   pro.setPid(101010);
		   pro.setPname("Mouse");
		   pro.setPrice(101.0);
		   pro.setQty(3.0);
		   pro.setStatus("Ava");
		   sec.saveOrUpdate(pro);
		   tx=sec.beginTransaction();
		   tx.commit();
		   System.out.println("The Record Are Save And Update Sucessfully........!");
	   }
	   catch (HibernateException he)
	   {
		he.printStackTrace();
		if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			tx.rollback();
		System.out.println("Plz Check The Data Or Contact Devloper...............!");
	   }
	   catch (Exception e)
	   {
		 e.printStackTrace();
	   }
   }
}
