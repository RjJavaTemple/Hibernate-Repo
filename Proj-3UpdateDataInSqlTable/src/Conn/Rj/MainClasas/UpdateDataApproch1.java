package Conn.Rj.MainClasas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClass;

//Update The Data in java9 Fecture..

public class UpdateDataApproch1 
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
		   SetterAndGetterMeyhod pro=new SetterAndGetterMeyhod();
		   //Set the value product...
		   pro.setPid(101001);
		   pro.setPname("Mahala");
		   pro.setPrice(10.0);
		   pro.setQty(3.2);
		   pro.setStatus("Not-Avalable");
		   
		   //Process The Tranaction
		   tx=sec.beginTransaction();
		   
		   //Put The Upadate value..
		   sec.update(pro);
		   
		   //Save The object...
		   tx.commit();
		   
		   System.out.println("The Object Are Update...!");
	   }//try
   }//main
}//class
