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
	 Session sec=UtialityImplementation.getSession();
	Transaction tx=null;
	 try(
			 factory;
			 sec
			 )
	   {
		 //Using The : (Colon) Symbol
			/*Query query=sec.createQuery("from SetAndGetImp where ActorId>=:min and ActorId<=:max");
			query.setParameter("min", 100);
			query.setParameter("max", 150);
			List<SetAndGetImp> list=query.getResultList();
			System.out.println(list);*/
		 
		 //Using The Sub-Query
		 Query query=sec.createQuery("from SetAndGetImp where ActorId=(select max (ActorId) from SetAndGetImp)");
		 List<SetAndGetImp> list=query.getResultList();
		 System.out.println(list);
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
		 
