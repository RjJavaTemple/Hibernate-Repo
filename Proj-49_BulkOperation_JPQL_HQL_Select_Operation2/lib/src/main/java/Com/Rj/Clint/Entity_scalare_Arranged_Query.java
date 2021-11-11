package Com.Rj.Clint;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class Entity_scalare_Arranged_Query 
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
			//1.Entity Query Having 0 or 1 record
			/* Query query=sec.createQuery("from SetAndGetImp where ActorId=?1");
			 query.setParameter(1, 103);
			 SetAndGetImp set=(SetAndGetImp)query.getSingleResult();
			 if(set==null)
				 System.out.println("No Record Are Found");
			 else
			 {
				 System.out.println("The Record Are:--");
				 System.out.println(set);
			 }*/
			 
			 //2.Scaler Query Having 0 Or Multiple Record
				/*Query query=sec.createQuery("select ActorId,ActorName from SetAndGetImp where ActorId=?1");
				query.setParameter(1, 102);
				Object[] row=(Object[])query.getSingleResult();
				if(row==null)
				 System.out.println("The Record Are Not Found");
				else
				{
				 System.out.println("the Record Are");
				 System.out.println(row[0]);
				 System.out.println(row[1]);
				}*/
			 
			 
			 //3.Scaler Query Having 0 Or 1 Record
				/*Query query=sec.createQuery("select ActorName from SetAndGetImp where ActorId=?1");
				query.setParameter(1, 103);
				String name=(String)query.getSingleResult();
				if(name==null)
				 System.out.println("the Recore Are Not Found");
				else
				{
				 System.out.println("The Record Are");
				 System.out.println("The Name Is :--->  "+name);
				}*/
			 
			 //4.Single Query Arranged Function
				/* Query query=sec.createQuery("select count(*) from SetAndGetImp");
				 long count=(long)query.getSingleResult();
				 System.out.println("The Total Id is--->"+count);*/
			 
			 //5.Multiple Query Arranged Function
			 Query query=sec.createQuery("select count(*),avg(ActorId),min(ActorId),max(ActorId),sum(ActorId) from SetAndGetImp");
			 Object row[]=(Object[])query.getSingleResult();
			 System.out.println("The Actor Toatal Id Is--->"+row[0]);
			 System.out.println("The Actor avg Id  Is--->"+row[1]);
			 System.out.println("The Actor min Id Is Is--->"+row[2]);
			 System.out.println("The Actor max Id  Is--->"+row[3]);
			 System.out.println("The Actor sum Is--->"+row[4]);
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
