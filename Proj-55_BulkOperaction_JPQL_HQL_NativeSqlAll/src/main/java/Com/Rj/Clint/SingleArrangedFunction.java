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

public class SingleArrangedFunction
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
		 NativeQuery quert=sec.createNativeQuery("select count(*)  from actor_info ");
         //Set The Scalar Query In The HB Data Type
		  quert.addScalar("COUNT(*)",StandardBasicTypes.INTEGER);
		  //process The Query
		  int count=(int)quert.getSingleResult();
		  System.out.println(count);
		
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
		 
