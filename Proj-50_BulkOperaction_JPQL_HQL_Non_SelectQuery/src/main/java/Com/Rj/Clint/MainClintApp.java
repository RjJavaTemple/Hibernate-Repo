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
			/* tx=sec.beginTransaction();
			 //Update Operaction in The Hql Table
			 Query query=sec.createQuery("update SetAndGetImp  set ActorCurrentFilm=?1 where  ActorName=?2");
			 query.setParameter(1,"Kach-Kack1");
			 query.setParameter(2, "Rashmi-1");
			 //execute The Query
			 int count=query.executeUpdate();
			 System.out.println(count);
			 tx.commit();
			 System.out.println("the No Of Record Are Affected");*/
		 
		 //Delete The Query
		 tx=sec.beginTransaction();
		 Query query=sec.createQuery("delete from SetAndGetImp where ActorCurrentFilm in (:addrs1,:addrs2)");
		 query.setParameter("addrs1"," kjbf");
		 query.setParameter("addrs2", "HJDJS");
		 //execute The Query
		 int count=query.executeUpdate();
		 System.out.println(count);
		 tx.commit();
		 System.out.println("the No Of Record Are Affected");
	   }
	   catch (HibernateException he)
	   {
		   if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly())
			   tx.rollback();
		   System.out.println("Object Input Time Problem");
		  he.printStackTrace();
	   }
	   catch (Exception e)
	   {
		   e.printStackTrace();
	   }
	 }
  }
		 
