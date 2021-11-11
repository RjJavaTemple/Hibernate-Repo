package Conn.Rj.Mian;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import Conn.Rj.Entity.SetAndGetClass;
import Conn.Rj.Utilit.UtilityImplement;

public class MianClintApp 
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
		   String result[]=sec.doReturningWork(con->{
			  
			   CallableStatement cs=con.prepareCall("{?=CALL SELECT_QUERY_IN_FUNCTION(?,?,?)}");
			   //Set the Out Or Return Paramiter
			   cs.registerOutParameter(1, Types.VARCHAR);
			   cs.registerOutParameter(3, Types.VARCHAR);
			   cs.registerOutParameter(4, Types.NUMERIC);
			   
			   //register The Return Paramioter
			   cs.setInt(2, 103);
			   
			   //execute The Query
			   cs.execute();
			   
			   //Gathere The Data
			   String resukt1[]=new String[3];
			   resukt1[0]=cs.getString(1);
			   resukt1[1]=cs.getString(3);
			   resukt1[2]=cs.getString(4);
			   
			   //Return The Result
			   return resukt1;
		   });
		   //Retrive The Data
		   System.out.println("The Data Are");
		   for(String res:result)
		   {
			   System.out.print(res+"  ");
		   }
		   System.out.println();
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
