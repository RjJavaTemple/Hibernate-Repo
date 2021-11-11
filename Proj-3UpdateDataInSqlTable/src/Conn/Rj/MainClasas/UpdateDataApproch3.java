package Conn.Rj.MainClasas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClass;

public class UpdateDataApproch3 
{
	 public static void main(String[] args)
	  {
		   SessionFactory factory=UtillImplementClass.getSessionFactory();
		   Session sec=UtillImplementClass.getSession();
		   Transaction tx=null;
		   try(   factory;
				    sec
				   )
		   {
			   //Call The Getter and setter Class..
			   SetterAndGetterMeyhod pro=sec.get(SetterAndGetterMeyhod.class, 101002);
			   if(pro==null)
			   {
				   System.out.println("The Record Are Not Found...");
			   }
			   else
			   {
				   tx=sec.beginTransaction();
				   pro.setPrice(101.0);
				   sec.update(pro);
				   tx.commit();
				   System.out.println("The Record Are Update...");
			   }
		   }//try
	   }//main 
}//class
