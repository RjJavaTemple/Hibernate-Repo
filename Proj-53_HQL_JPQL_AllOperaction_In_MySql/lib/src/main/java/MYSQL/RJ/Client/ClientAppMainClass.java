package MYSQL.RJ.Client;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import MYSQL.RJ.Entity.StudentTab;
import MYSQL.RJ.Utlity.UtialityImplemetation;

public class ClientAppMainClass 
{
     public static void main(String[] args)
     {
    	 //Create The Session factory Object
    	 SessionFactory factory=UtialityImplemetation.getSessionFactory();
    	 //Create The Session Object
    	 Session sec=UtialityImplemetation.getSession();
    	 //Create The Transaction
    	 Transaction tx=null;
    	 
	 try(
			 factory;
			 sec
			 )
	 {
	       //Process The Query
		 Query query=sec.createQuery("from StudentTab where StuSno>=:min and StuSno<=?2");
		 //Set the Query Paramiter In The java App
		 query.setParameter("min", 1);
		 query.setParameter(2, 10);
		 
		 //Create the List Object
		 List<StudentTab> list=query.getResultList();
		 //Retrive The Data In The Db table
		 list.forEach(student->{
			 System.out.println(student);
		 });
		 
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
