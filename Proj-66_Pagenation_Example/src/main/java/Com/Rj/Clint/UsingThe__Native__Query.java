package Com.Rj.Clint;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Set;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class UsingThe__Native__Query 
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
		  NativeQuery query=sec.createNativeQuery("select count(*) from SetAndGetImp");
		  query.addScalar("count(*)",StandardBasicTypes.LONG);
		  Long rowcount=(Long) query.getSingleResult();
		  
		  //using The Scanner Object
		  System.out.println("Enter The RowNum Start Number::");
		 Scanner sc=new Scanner(System.in);
		 int pagesize=sc.nextInt();
		 Long pagecount=rowcount/pagesize;
		 pagecount=(rowcount%pagesize==0)?pagecount:++pagecount;
		 System.out.println("No Of Page Are Count---->"+pagecount);
		  
		  //Prepare The 2nd Query
		  NativeQuery quert1=sec.createNativeQuery(" select * from SetAndGetImp");
		  quert1.addEntity(SetAndGetImp.class);
		  for(int i=0;i<rowcount;i+=pagesize)
		  {
		System.out.println("----------"+(i+1)+"Page Details");
		//Set The Pagenation Setting
		  quert1.setFirstResult(i);
		  quert1.setMaxResults(pagesize);
		  //retrive The Data In the DB Table
		  List<SetAndGetImp> list=quert1.getResultList();
		  //Process The Data Using The Lambda Expression
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
		  e.printStackTrace();
	  }
  }
}
