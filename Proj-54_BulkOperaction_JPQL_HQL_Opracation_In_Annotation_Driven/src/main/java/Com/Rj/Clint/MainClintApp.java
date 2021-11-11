package Com.Rj.Clint;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class MainClintApp 
{
  public static void main(String[] args)
  {
	  //Create The SessionFactory Object
	 SessionFactory factory=UtialityImplementation.getSessionFactory();
	 //Create The Session Object
	 Session sec=UtialityImplementation.getSession();
	Transaction tx=null;
	 try(
			 factory;
			 sec
			 )
	   {
			//Prepare The HQL Query..
		     Query query=sec.createNamedQuery("Hibernate_Select_Operaction");
		     //Set In The Query Paramiter
		    query.setParameter(1,100);
		    query.setParameter(2, 200);
		    //Create The List Object
		    List<SetAndGetImp> list=query.getResultList();
		    //Retrieved The Data In Lambda Through
		     list.forEach(SetId->{
		    	 System.out.println(SetId);
		     });
		     
		     System.out.println("-------------------------------------------------------------------------------------------");
		     tx=sec.beginTransaction();
		     Query query2=sec.createNamedQuery("Hibernate_Update_Operaction");
		     query2.setParameter(1,"White");
		     query2.setParameter(2, 103);
		     int count=query2.executeUpdate();
		     tx.commit();
		     System.out.println("The No Of Record Are Affected Are:-->"+count);
	   }
	   catch (HibernateException he)
	   {
			   if(tx!=null ||tx.getStatus()!=null || tx.getRollbackOnly())
				   tx.rollback();
			   System.out.println("The Object input Time Problem....");
		   he.printStackTrace();
	   }
	   catch (Exception e)
	   {
		   System.out.println("The ");
		   e.printStackTrace();
	   }
	 }
  }
		 
