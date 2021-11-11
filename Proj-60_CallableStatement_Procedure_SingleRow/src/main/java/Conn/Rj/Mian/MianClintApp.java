package Conn.Rj.Mian;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;

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
	      //Call The Procedure
		   ProcedureCall call=sec.createStoredProcedureCall("LOGINIDPASS_PROCEDURE");
		   //Set The paramiter In The query Paramiter
		   call.registerParameter(1, String.class, ParameterMode.IN).bindValue("101001");
		   call.registerParameter(2, String.class, ParameterMode.IN).bindValue("rjdj123");
		   call.registerParameter(3, String.class, ParameterMode.OUT);
		   
		   //Call The Pl Sql Stored Procesure
		   String res=(String) call.getOutputParameterValue(3);
		   System.out.println(res);
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
