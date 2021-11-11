package Try.Re.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rj.entity.product;

import Try.Re.StaticFile.StaticImplementFile;

public class Main_Class 
{
   public static void main(String[] args)
   {
	   //Get Session Factor Object
	   SessionFactory factory=StaticImplementFile.getSessionFactory();
	   
	   //Get Sessioon Object
	   Session sec=StaticImplementFile.getSession();
	   
	   try
	   {
		   product pro=sec.get(product.class,101001);
		   if(pro==null)
			   System.out.println("Record Are Not Found");
		   else
			   System.out.println("The Record Are::-");
		       System.out.println(pro.getPid()+"  "+pro.getPname()+"  "+pro.getPrice()+"  "+pro.getQty()+"  "+pro.getStatus());
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
		   StaticImplementFile.getSessionFactory().close();
		   StaticImplementFile.getSession().close();
	   }
   }//main
}//class
