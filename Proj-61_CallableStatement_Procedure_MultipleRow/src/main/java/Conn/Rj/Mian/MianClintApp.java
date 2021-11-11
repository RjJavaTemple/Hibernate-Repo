package Conn.Rj.Mian;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
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
		  //Multiple Query
		   ProcedureCall  call=sec.createStoredProcedureCall("MULTIPLE_PROCEDURE");
		   //Set The Paramiter
		   call.registerParameter(1, String.class,ParameterMode.IN).bindValue("Mirzapur");
		   call.registerParameter(2, String.class,ParameterMode.IN).bindValue("Osera");
		   call.registerParameter(3, String.class,ParameterMode.IN).bindValue("Chandi");
		   call.registerParameter(4, SetAndGetClass.class,ParameterMode.REF_CURSOR);
		   
		   //Retrive Theb Data in The Lambada
		   List<Object[]> list=call.getResultList();
		   list.forEach(row->{
			   for(Object obj:row)
			   {
				   System.out.print(obj+"      ");
			   }
			   System.out.println();
		   });
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
