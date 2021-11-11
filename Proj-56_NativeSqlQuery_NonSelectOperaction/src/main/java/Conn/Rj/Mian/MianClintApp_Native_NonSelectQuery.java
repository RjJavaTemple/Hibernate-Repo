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
			 //Prepare The NativeQuery
			NativeQuery query=sec.createNativeQuery("SELECT STUID,STUNAME,STUADDRESS,STUMARK,STUSEC FROM STUDENT WHERE STUNAME=?1");
			//Set The Paramiter
			query.setParameter(1, "Ranjan");
			//retrive The data In the List Object
			List<Object[]> list=query.getResultList();
			//Process The data in lambda
			list.forEach(row->{
				for(Object obj:row)
				{
					System.out.print(obj+" ");
				}
				System.out.println();
			});
		   
		   //Insert The Data In The Student Table using The Native Sql Query
			/*tx=sec.beginTransaction();
			NativeQuery query1=sec.createNativeQuery("insert into Student values(?,?,?,?,?)");*/
			/*    //Set the Paramiter
			query1.setParameter(1,106);
			query1.setParameter(2, "Ranjan-1");
			query1.setParameter(3, "Mirzapur-1");
			query1.setParameter(4, 300.00);
			query1.setParameter(5, "AB");
			int count=query1.executeUpdate();
			tx.commit();
			if(count==0)
			{
				System.out.println("The Record Are Back");
			}
			else
			System.out.println("the Record Are Saved SucessFully");*/
	   }
	   catch (HibernateException he)
	   {
		   he.printStackTrace();
		   if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly())
			   tx.rollback();
		   System.out.println("the Object Input Time Problem Are Arrised........!");
	   }
	   catch (Exception e)
	   {
		   e.printStackTrace();
	  }
  }
}
