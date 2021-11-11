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
		
		   //Update The Query.........
		   //UPDATE STUDENT SET STUADDRESS=:NEWADD WHERE STUID=:IDNAME
			tx=sec.beginTransaction(); 
			NativeQuery query2=sec.getNamedNativeQuery("UPDAET_QUERY");
			query2.setParameter("NEWADD", "Hyd");
			query2.setParameter("IDNAME", 105);
			int count=query2.executeUpdate();
			tx.commit();
			if(count==0)
			  System.out.println("the Recored Not Update");
			else
			  System.out.println("The Record Update");
		   
			System.out.println("----------------------------------------------------------------------------------");
			
			//Rerive The complite Data In The Db Table
			//SELECT STUID,STUNAME,STUADDRESS,STUMARK,STUSEC FROM STUDENT WHERE STUADDRESS=?
			NativeQuery query3=sec.getNamedNativeQuery("SELECT_OPERACATION1");
			query3.setParameter(1, "Mirzapur");
			List<SetAndGetClass> list=query3.getResultList();
			list.forEach(System.out::println);
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
