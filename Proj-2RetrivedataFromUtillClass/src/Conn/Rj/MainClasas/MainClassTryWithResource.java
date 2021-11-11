package Conn.Rj.MainClasas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClass;

public class MainClassTryWithResource 
{
   public static void main(String[] args)
   {
	   try(
			   //GetSessionFactory Object..
			   SessionFactory factory=UtillImplementClass.getSessionFactory();
			   
			   //Get Session Object
			   Session sec=UtillImplementClass.getSession();
			   )
	   {
		   SetterAndGetterMeyhod set=sec.get(SetterAndGetterMeyhod.class, 101001);
		   if(set==null)
			   System.out.println("Record Are Not Found");
		   else
		   {
			   System.out.println("The Record Are::-");
		       System.out.println(set.getPid()+"  "+set.getPname()+"  "+set.getPrice()+"  "+set.getQty()+"  "+set.getStatus());
		       System.out.println(set.getPid()+"  "+set.getPname()+"  "+set.getPrice()+"  "+set.getQty()+"  "+set.getStatus());
		       System.out.println(set.getPid()+"  "+set.getPname()+"  "+set.getPrice()+"  "+set.getQty()+"  "+set.getStatus());
		   }
	   }
   } 
}
