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

public class AddTheMultipleCondition 
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
		  //Add The Roor Object To The Criteria Object Query-2
		  query.select(root).where(builder.and(builder.ge(root.get("ActorId"), 100),
		                                          builder.like(root.get("ActorName"), "R%")
				  ));
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
