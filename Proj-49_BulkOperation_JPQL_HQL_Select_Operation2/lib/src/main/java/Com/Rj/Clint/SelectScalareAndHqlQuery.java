package Com.Rj.Clint;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class SelectScalareAndHqlQuery 
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
			 //Query  query=sec.createQuery("from SetAndGetImp where ActorAddress=?1");
			 
			//1.Using The HQL Select Query
			/* query.setParameter(1, "hyd");
			 List<SetAndGetImp> list=query.getResultList();
			 list.forEach(actor->{
				 System.out.println(actor);
			 });*/
			 
			 //2.Scalare Query MultipleColumn Value
				/*Query  query=sec.createQuery("SELECT ActorId,ActorName from SetAndGetImp where ActorAddress=?1");
				query.setParameter(1, "hyd");
				List<Object[]> list=query.getResultList();
				list.forEach(row->{
				 for(Object val:row)
					 System.out.println(val+" ");
				 System.out.println();
				});*/
			 
			 //3.Scalar Query Single Column Value
				/* Query  query=sec.createQuery("SELECT ActorName from SetAndGetImp where ActorAddress=?1");
				 query.setParameter(1, "hyd");
				 List<String> list=query.getResultList();
				 list.forEach(name->{
						 System.out.println(name);
				 });*/
			 
			 //4.using The Iterator Method
			 Query  query=sec.createQuery("SELECT ActorId,ActorName from SetAndGetImp where ActorAddress=?1");
			 query.setParameter(1, "hyd");
			 Iterator<Object[]> it=query.iterate();
			 while(it.hasNext())
			 {
				 Object row[]=it.next();
				 for(Object val:row)
					 System.out.println(val+" ");
				 System.out.println();
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
