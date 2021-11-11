package Com.Rj.Clint;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class LambadaExpression 
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
			 Query  query=sec.createQuery("from SetAndGetImp");
			 List<SetAndGetImp> list=query.getResultList();
			 
			 //1.Lambda Expression		 
			/*list.forEach(actor->{
				System.out.println(actor);
			});*/
		 
		 //2.Lambda With Methos Reference
		 //list.forEach(System.out::println);
			 
			 //3.Lambda With Methos Reference Stream api
			// list.stream().forEach(System.out::println);
			 
			 //4.Enhenced for loop
				/* for(SetAndGetImp set:list)
				 {
					 System.out.println(set);
				 }*/
			 
			 //5.Using Itertator
			 Iterator<SetAndGetImp> it=query.iterate();
			 while(it.hasNext())
			 {
				 SetAndGetImp set=it.next();
				 System.out.println(set);
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
	  }

}
