package Com.Rj.Clint;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class Hiberinate_Criteria_Api 
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
		   //Create The Criteria Object
		   Criteria criteria=sec.createCriteria(SetAndGetImp.class);
		   //create The Projection Object
		   Projection proj1=Projections.count("ActorId");
		   //Set The Prijection In The Criteria
		   criteria.setProjection(proj1);
		   //set The Cout In The Row
		   long rowcount=(long) criteria.list().get(0);
		   
		   //Evalute The Number oF Page
		   //Using The Scanner Class
		   Scanner sc=new Scanner(System.in);
		   System.out.println("Enter The Page Size");
		   int pagesize=sc.nextInt();
		   long pagesizecount=rowcount/pagesize;
		   pagesizecount=(rowcount%pagesize==0)?pagesizecount:++pagesizecount;
		   
		   //Display The Results
		   Criteria criteria1=sec.createCriteria(SetAndGetImp.class);
		   for(int i=0,pageNo=1;i<rowcount;i+=pagesize,pageNo++)
		   {
			   System.out.println("The Page Are---->"+pageNo);
			   //Setting The Pagenation Methods
			   criteria1.setFirstResult(i);
			   criteria1.setMaxResults(pageNo);
			   //Retrive The Data Using The List Object
			   List<SetAndGetImp> list=criteria1.list();
			   //Process The Data
			   list.forEach(Table->{
				   System.out.println(Table);
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
