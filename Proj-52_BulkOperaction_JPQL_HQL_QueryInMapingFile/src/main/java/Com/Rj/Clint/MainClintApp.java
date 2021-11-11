package Com.Rj.Clint;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class MainClintApp 
{
  public static void main(String[] args)
  {
	  //Create The SessionFactory Object
	 SessionFactory factory=UtialityImplementation.getSessionFactory();
	 //Create The Session Object
	 Session sec=factory.openSession();
	 try(
			 factory;
			 sec
			 )
	   {
			//Prepare The Query
		 Query query=sec.getNamedQuery("HQL_GET_SETANDGETIMP_BY_ACTORID_RANGE");
		 //Set The Query Paramiter
		 query.setParameter(1, 100);
		 query.setParameter(2, 200);
		 //Retrive The Data In The Table
		 List<SetAndGetImp> list=query.getResultList();
		 list.forEach(actor->{
			 System.out.println(actor);
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
		 
