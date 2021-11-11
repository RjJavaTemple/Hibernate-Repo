package Com.Rj.Clint;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class SelectQuery 
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
		  //Retrive The Data Using The List Object
		  List<SetAndGetImp> list=criteria.list();
		  //Process The Data Using Lambda Expression
		  list.forEach(System.out::println);
	   }
   }
}
