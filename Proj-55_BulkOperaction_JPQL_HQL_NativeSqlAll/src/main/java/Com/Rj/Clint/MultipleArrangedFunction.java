package Com.Rj.Clint;

import java.util.List;

import javax.persistence.NamedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class MultipleArrangedFunction
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
		  //Prepare The NativeQuery
		 NativeQuery quert=sec.createNativeQuery("select count(*),max(ActorId),min(ActorId),avg(ActorId)  from actor_info ");
         //Set The Scalar Query In The HB Data Type
		  quert.addScalar("COUNT(*)",StandardBasicTypes.INTEGER);
		  quert.addScalar("MAX(ACTORID)",StandardBasicTypes.INTEGER);
		  quert.addScalar("MIN(ACTORID)",StandardBasicTypes.INTEGER);
		  quert.addScalar("AVG(ACTORID)",StandardBasicTypes.FLOAT);
		  //process The Query
		Object row[] =(Object[])quert.getSingleResult();
		System.out.println("the Count Of Empid"+row[0]);
		System.out.println("the Count Of Max Empid"+row[1]);
		System.out.println("the Count Of Min Empid"+row[2]);
		System.out.println("the Count Of Avg Empid"+row[3]);
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
		 
