package Com.Rj.Clint;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class Using_Like_Or_And_IsNull 
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
		   //Create The Criteria Query
		  Criteria criteria=sec.createCriteria(SetAndGetImp.class);
		  
		  //Add The Condition In The Query-1
		  Criterion condition1=Restrictions.like("ActorName", "R%");
		 
		//Add The Condition In The Query-2
		  Criterion condition2=Restrictions.in("ActorAddress", "mum","hyd");
		 
		//Add The Condition In The Query-3
		  Criterion condition3=Restrictions.isNull("ActorSalary");
		 
			//Add The Condition In The Query-4
		  Criterion condition4=Restrictions.or(condition1,condition2);
		 
			//Add The Condition In The Query-5
		  Criterion condition5=Restrictions.and(condition4,condition3);
		  
		  
		  //Prepare The Order Object 
		  Order order=Order.desc("ActorName");
		  //Add The Object
		  criteria.add(condition5);
		  criteria.addOrder(order);
		  
		  
		  //Retrive The Data Using The List Object
		  List<SetAndGetImp> list=criteria.list();
		  //Process The Data Using Lambda Expression
		  list.forEach(System.out::println);
	   }
   }
}
