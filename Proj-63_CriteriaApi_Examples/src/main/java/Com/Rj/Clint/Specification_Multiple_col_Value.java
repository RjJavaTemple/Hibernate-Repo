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

public class Specification_Multiple_col_Value 
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
		   Projection p1=Projections.property("ActorId");
		   Projection p2=Projections.property("ActorName");
		   //Add The Projection ProjectionList
		   ProjectionList plist=Projections.projectionList();
		   plist.add(p1);
		   plist.add(p2);
		   //Create The Critation Object
		   Criterion condition1=Restrictions.between("ActorId", 100, 150);
		   //Create The Order Object
		   Order order=Order.asc("ActorName");
		   //Add The Object  To CriteriaObject
		   criteria.add(condition1);
		   criteria.addOrder(order);
		   criteria.setProjection(plist);
		   //Execute The Qbc Logic
		   List<Object[]> list=criteria.list();
		   //Process The Data Using The ForEach Lambada Expression
		   list.forEach(row->{
			   for(Object obj:row)
			   {
				   System.out.print(obj+"   ");
			   }
			   System.out.println();
		   });
	   }
   }
}