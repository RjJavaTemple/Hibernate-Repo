package Com.Rj.Clint;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class Using_Like_in_Base_Object 
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
		  Criterion condition1=Restrictions.ge("ActorId", 100);
		  //Process The Add Query
		  criteria.add(condition1);
		//Add The Condition In The Query-2
		  Criterion condition2=Restrictions.in("ActorName", "Ranjan","Rashmi-1");
		  //Process The Add Query
		  criteria.add(condition2);
		  
		  
		  //Retrive The Data Using The List Object
		  List<SetAndGetImp> list=criteria.list();
		  //Process The Data Using Lambda Expression
		  list.forEach(System.out::println);
	   }
   }
}
