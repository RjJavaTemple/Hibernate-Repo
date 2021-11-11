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

public class AddCondition2nd 
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
		  //add The Root Object To Criteria Query Object (THIS IS THE METH-1)
		  //query.select(root).where(root.get("ActorAddress").in("mum","hyd")).orderBy(builder.asc(root.get("ActorName")));
		//add The Root Object To Criteria Query Object (THIS IS THE METH-2)
		  query.select(root).where(root.get("ActorAddress").in("mum","hyd"));
		 //Preepare The Query In T he Db Table
		  Query query2=sec.createQuery(query);
		  //retrive The Required The Data In The Bd Table
          List<SetAndGetImp> list=query2.getResultList();
          //Using The Lambada Expression
          list.forEach(
        		  System.out::println
        		  );
          
	  }
  } 
}
