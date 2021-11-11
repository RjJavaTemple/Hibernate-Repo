package Com.Rj.Clint;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class JPA_Criteria_Api 
{
   public static void main(String[] args)
   {
	  //Create The SessionFactory object
	   SessionFactory factory=UtialityImplementation.getSessionFactory();
	   //Create The Session Object
	   Session sec=UtialityImplementation.getSession();
	   try(factory;
			   sec
			   )
	   {
		 //Create The Criteria Builder object
		   CriteriaBuilder builder=sec.getCriteriaBuilder();
		   //create The Criteria Object
		   CriteriaQuery<Long> query=builder.createQuery(Long.class);
		   //create The Root Object
		   Root<SetAndGetImp> root=query.from(SetAndGetImp.class);
		   query.multiselect(builder.count(root.get("ActorId")));
		   //create The Query Object
		   Query quer=sec.createQuery(query);
		   //Create The Long Object Set The  Value
		   long rowcount=(long) quer.getSingleResult();
		   
		   //use The Scanner Class
		   Scanner sc=new Scanner(System.in);
		   System.out.println("Enter The Pagesize");
		   int pagesize=sc.nextInt();
		   long pagecount=rowcount/pagesize;
		   pagecount=(rowcount%pagecount==0)?pagecount:++pagecount;
		   System.out.println("The Page Are---->"+pagecount);
		   
		   //Display The Criteria Object
		   CriteriaQuery<SetAndGetImp> query1=builder.createQuery(SetAndGetImp.class);
		   //Set The Root Object In The Criteria Query
		   Root<SetAndGetImp> root1=query1.from(SetAndGetImp.class);
		   query1.select(root1);
		   //Set the Second Query Object
		   Query quer1=sec.createQuery(query1);
		   //Use The For Loop
		   for(int i=0,pageNo=1;i<rowcount;i+=pagesize,pageNo++)
		   {
			   System.out.println("The Page Record Are"+pageNo);
			   //Setting The Pagenation
			   quer1.setFirstResult(i);
			   quer1.setMaxResults(pageNo);
			   //retrive The Data Using The List Object
			   List<SetAndGetImp> list=quer1.getResultList();
			   //Retrive The Data Using Lambda
			   list.forEach(row->{
				   System.out.println(row);
			   });
		   }
		 }
	   catch (HibernateException he)
	   {
		   he.printStackTrace();
	   }
	   catch (Exception e)
	   {
		   System.out.println(e);
	   }
   }
}
