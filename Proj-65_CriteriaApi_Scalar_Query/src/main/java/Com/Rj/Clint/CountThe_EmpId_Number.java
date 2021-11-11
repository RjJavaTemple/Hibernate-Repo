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

public class CountThe_EmpId_Number 
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
		   CriteriaQuery<Long> CriQuery=builder.createQuery(Long.class);
		   //Create The Root Object
		   Root<SetAndGetImp> root=CriQuery.from(SetAndGetImp.class);
		   //Add The Column Name
		   CriQuery.multiselect(builder.count(root.get("ActorId")));
		   //Prepare The Query Object
		   Query query=sec.createQuery(CriQuery);
		   //Execute The Query
		   Long count=(Long) query.getSingleResult();
		   //See The Data In Console
		   System.out.println("The EmpId Val Is-------->"+count);
		 
	   }
   }
}
