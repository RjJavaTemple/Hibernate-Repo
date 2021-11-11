package Com.Rj.Clint;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class RetriveTheData
{
  public static void main(String[] args)
  {
	   //Create The SessionFactory Object
	  SessionFactory factory=UtialityImplementation.getSessionFactory();
	  
	  //Create The Session Object
	  Session sec=UtialityImplementation.getSession();
	  try(factory;
			  sec
			  )
	  {
		  //Retrive The Data Table Use The get Method
		 Query query=sec.createQuery("from SetAndGetImp");
		 List<SetAndGetImp> list=query.getResultList();
		 list.forEach(row->{
			 System.out.println(row);
		 });
	  }
  }
}
