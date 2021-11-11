package Com.Rj.Clint;

import java.util.List;

import javax.persistence.NamedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class RetriveDataNativeSqlSingleRow
{
  public static void main(String[] args)
  {
	  //Create The SessionFactory Object
	 SessionFactory factory=UtialityImplementation.getSessionFactory();
	 //Create The Session Object
	 Session sec=UtialityImplementation.getSession();
	 try(
			 factory;
			 sec
			 )
	   {
		 //The Retrive The Dat In The Native query I  the Multiple Query.........................
		  //Prepare The NativeSql Query..................
		 NativeQuery query=sec.createNativeQuery("select * from Actor_Info");
		 //Add The Query 
		 query.addEntity(SetAndGetImp.class);
		 //Process The Query
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
		 
