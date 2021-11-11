package Com.Rj.Clint;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class MultipleCount_Query 
{
   public static void main(String[] args)
   {
	  //Create The SessionFactory
	   SessionFactory factory=UtialityImplementation.getSessionFactory();
	   //Create The Session
	   Session sec=UtialityImplementation.getSession();
	   
	   try(factory;sec)
	   {
		   //Create The Criteria Builder Object
		   CriteriaBuilder builder=sec.getCriteriaBuilder();
		   //Create The Criteria Query Object
		   CriteriaQuery<Object[]> CriQuery=builder.createQuery(Object[].class);
		   //Create The Root Object
		   Root<SetAndGetImp> root=CriQuery.from(SetAndGetImp.class);
		   //Add The Column Name
		   CriQuery.multiselect(builder.count(root.get("ActorId")),
				   builder.sum(root.get("ActorId")),
				   builder.avg(root.get("ActorId")),
				   builder.min(root.get("ActorId")),
				   builder.max(root.get("ActorId"))
				   );
		   //Prepare The Query Object
		   Query query=sec.createQuery(CriQuery);
		   //Execute The Query
		   List<Object[]> list=query.getResultList();
		   Object result[]=list.get(0);
		  System.out.println("The Count Val is---->"+result[0]);
		  System.out.println("The Sum Val is---->"+result[1]);
		  System.out.println("The Avg Val is---->"+result[2]);
		  System.out.println("The Min Val is---->"+result[3]);
		  System.out.println("The Max Val is---->"+result[4]);
		 
	   }
   }
}
