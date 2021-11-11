package Conn.Rj.Mian;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import Conn.Rj.Entity.SetAndGetClass;
import Conn.Rj.Utilit.UtilityImplement;

public class MianClintApp_Native_NonSelectQuery 
{
  public static void main(String[] args)
  {
	  //Create The SEssionFactory  Object
	   SessionFactory factory=UtilityImplement.getSessionFactory();
	   
	   //Create The Session factory
	   Session sec=UtilityImplement.getSession();
	   
	   //Create The The Trabtion Object
	   Transaction tx=null;
	   try(
			   factory;
			   sec
			   )
	   {
		   
			NativeQuery query1=sec.getNamedNativeQuery("SELECT_OPERACATION2");
			query1.setParameter(1, 100);
			query1.setParameter(2, 200);
			List<Object[]> list1=query1.getResultList();
			list1.forEach(row->{
			   for(Object val:row)
			   {
				   System.out.println("The Value Are:-----");
				   System.out.print(val+" ");
			   }
			   System.out.println();
			});
			
			System.out.println("----------------------------------------------------------------------------------");
			tx=sec.beginTransaction(); 
			NativeQuery query2=sec.getNamedNativeQuery("UPDAET_QUERY");
			query2.setParameter("newadd", "Mum");
			query2.setParameter("idname", 104);
			int count=query2.executeUpdate();
			tx.commit();
			if(count==0)
			  System.out.println("the Recored Not Update");
			else
			  System.out.println("The Record Update");
		   
			System.out.println("----------------------------------------------------------------------------------");
			
		   NativeQuery query3=sec.getNamedNativeQuery("SELECT_OPERACATION1");
			 query3.setParameter(1, "Mirzapur");
			 List<SetAndGetClass> list2=query3.getResultList();
			 list2.forEach(System.out::println); 
	   }
	   catch (HibernateException he)
	   {
		   tx.rollback();
		   System.out.println("the Object InputTime Problem..");
		   he.printStackTrace();
	   }
	   catch (Exception e)
	   {
		   e.printStackTrace();
	  }
  }
}
