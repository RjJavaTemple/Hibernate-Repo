package Com.Rj.Clint;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Set;
import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class RwoNumExample1 
{
  public static void main(String[] args)
  {
	  //Create The Session Factory Object
	  SessionFactory factory=UtialityImplementation.getSessionFactory();
	  //Create The Sesson Object
	  Session sec=UtialityImplementation.getSession();
	  try(factory;
			  sec
			  )
	  {
		  //Create The Query Object
		  Query query=sec.createQuery("from SetAndGetImp");
		  //Set The Pagenation Setting
		  query.setFirstResult(1);
		  query.setMaxResults(2);
		  //retrive The Data In the DB Table
		  List<SetAndGetImp> list=query.getResultList();
		  //Process The Data Using The Lambda Expression
		  list.forEach(row->{
			  System.out.println(row);
		  });
	  }
  }
}
