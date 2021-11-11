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

public class ScalarQuery_Multiple_Condition 
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
		   CriQuery.multiselect(root.get("ActorId"),root.get("ActorName"),root.get("ActorAddress"))
		                .where(builder.and(
		                		builder.ge(root.get("ActorId"), 100),
		                		builder.le(root.get("ActorId"), 150)
		                		));
		   // Prepare The Query Object
		   Query query=sec.createQuery(CriQuery);
		   //Retrive The Data Using List Object
		   List<Object[]> list=query.getResultList();
		   //Process The Retrive Data
		   list.forEach(row->{
			   for(Object obj:row)
			   {
				   System.out.print(obj+" ");
			   }
			   System.out.println();
		   });
	   }
   }
}
