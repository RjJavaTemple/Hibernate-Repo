package Conn.Rj.MainClasas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClass;



public class MainClass 
{
	 public static void main(String[] args)
	   {
		   //Get Session Factor Object
		   SessionFactory factory=UtillImplementClass.getSessionFactory();
		   
		   //Get Sessioon Object
		   Session sec=UtillImplementClass.getSession();
		   
		   try
		   {
			   SetterAndGetterMeyhod pro=sec.get(SetterAndGetterMeyhod.class,101001);
			   if(pro==null)
				   System.out.println("Record Are Not Found");
			   else
			   {
				   System.out.println("The Record Are::-");
			       System.out.println(pro.getPid()+"  "+pro.getPname()+"  "+pro.getPrice()+"  "+pro.getQty()+"  "+pro.getStatus());
			   }
			   }
		   catch (HibernateException he)
		   {
			he.printStackTrace();
		   }
		   catch (Exception e)
		   {
			e.printStackTrace();
		   }
		   finally
		   {
			   //Close The UtillClass All Object(Static Class)
			   UtillImplementClass.getSessionFactory().close();
			  UtillImplementClass.getSession().close();
		   }
	   }//main
}
