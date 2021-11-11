package Com.Rj.Clint;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class SelectOperacation 
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
		  //Create The Criteria Builder
		  CriteriaBuilder builder=sec.getCriteriaBuilder();
		  //Create The CriteriaQuery Object
		  CriteriaQuery<SetAndGetImp> query=builder.createQuery(SetAndGetImp.class);
		  //Create The Root Object
		  Root<SetAndGetImp> root=query.from(SetAndGetImp.class);
		  //add The Root Object To Criteria Query Object
		  query.select(root);
		  //Prepare The Query Object having CriteriaQuery Object
		  Query query1=sec.createQuery(query);
		  //execute The Logic
		  List<SetAndGetImp> list=query1.getResultList();
		  //Retried The Data In The Db Table
		  //Using The Java-8 Lambda Expression
		  list.forEach(row->{
			 System.out.println(row);
		  });
	  }
  } 
}
