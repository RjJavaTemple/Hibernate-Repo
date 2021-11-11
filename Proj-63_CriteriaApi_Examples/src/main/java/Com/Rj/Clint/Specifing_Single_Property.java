package Com.Rj.Clint;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class Specifing_Single_Property 
{
   public static void main(String[] args)
   {
	  //Create The SessionFactory
	   SessionFactory factory=UtialityImplementation.getSessionFactory();
	   //Create The Session
	   Session sec=UtialityImplementation.getSession();
	   try(factory;
			   sec
			   )
	   {
		 //Create The Criteria Object
		   Criteria criteria=sec.createCriteria(SetAndGetImp.class);
		   //Create The Projection Object
		   Projection p2=Projections.property("ActorName");
		   //Create The Condition
		   Criterion condition1=Restrictions.in("ActorAddress","hyd","mum");
		   //Add the Projection
		   criteria.add(condition1);
		   criteria.setProjection(p2);
		   
		  
		   //Execute The Qbc Logic
		   List<String> list=criteria.list();
		   //Process The Data Using The ForEach Lambada Expression
		   list.forEach(row->{
			   System.out.println(row);
		   });
	   }
   }
}