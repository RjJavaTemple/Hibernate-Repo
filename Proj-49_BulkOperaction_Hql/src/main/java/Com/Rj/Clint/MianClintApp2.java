package Com.Rj.Clint;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class MianClintApp2 
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
			 
	             //1.Lambada Expression		 
				/*list.forEach(actor->{
					System.out.println(actor);
				});*/
			 
			 //2.
			 //list.forEach(System.out::println);
			 
			 list.stream().forEach(System.out::println);
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
