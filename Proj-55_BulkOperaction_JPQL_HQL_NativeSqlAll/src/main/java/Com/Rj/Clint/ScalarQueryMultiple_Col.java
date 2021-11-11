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

public class ScalarQueryMultiple_Col
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
		 NativeQuery quert=sec.createNativeQuery("SELECT ACTORID,ACTORNAME,ACTORADDRESS FROM  ACTOR_INFO WHERE ACTORADDRESS"
		 		+ " IN (?,?,?) ORDER BY ACTORADDRESS DESC ");
         //Set The Scalar Query In The HB Data Type
		  quert.addScalar("ACTORID",StandardBasicTypes.INTEGER);
		  quert.addScalar("ACTORNAME",StandardBasicTypes.STRING);
		  quert.addScalar("ACTORADDRESS",StandardBasicTypes.STRING);
		  //set The Paramiter In The Query
		  quert.setParameter(1, "hyd");
		  quert.setParameter(2, "mum");
		  quert.setParameter(3, "ckl");
		  //Process The Query
		  List<Object[]> list=quert.getResultList();
		  list.forEach(row->{
			 for(Object col:row)
			 {
				 System.out.print(col+" ");
			 }
			 System.out.println();
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
		 
