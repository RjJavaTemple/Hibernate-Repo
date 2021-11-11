package MYSQL.RJ.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import MYSQL.RJ.Entity.StudentTab;
import MYSQL.RJ.Utlity.UtialityImplemetation;

public class InsertData 
{
   public static void main(String[] args)
   {
	   //Create The Session factory Object
  	 SessionFactory factory=UtialityImplemetation.getSessionFactory();
  	 //Create The Session Object
  	 Session sec=factory.openSession();
  	 //Create The Transaction
  	Transaction tx=null;
  	  try(
  			  factory;
  			  sec
  			  )
  	  {
  		  //Enter the Data In The MySql Table
  		  StudentTab stu=new StudentTab();
  		  stu.setStuName("Rj..Rj.Man");
  		  stu.setStuAddrs("Ckl-2");
  		  stu.setStuMark(110.0);
  		  stu.setStuSec('A');
  		  stu.setStuTotalMark(600.0);
  		  sec.saveOrUpdate(stu);
  		  tx=sec.beginTransaction();
  		  tx.commit();
  		  System.out.println("the Object Are Savd SucessFully");
  	  }
  	  catch (HibernateException he)
  	  {
		  he.printStackTrace();
	  }
  	  catch (Exception e)
  	  {
		   e.printStackTrace();
	  }
   }
}
