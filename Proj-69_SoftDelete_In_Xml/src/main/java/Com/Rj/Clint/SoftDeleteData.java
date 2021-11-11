package Com.Rj.Clint;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class SoftDeleteData
{
  public static void main(String[] args)
  {
	  //Create The SessionFactory  Object
	  SessionFactory factory=UtialityImplementation.getSessionFactory();
	  //Create The Session Object
	  Session sec=UtialityImplementation.getSession();
	  //Ceateh The Tranction Object
	  Transaction tx=null;
	  try(
			  factory;
			  sec
			  )
	  {
		  //Create The Object
		  SetAndGetImp account=sec.get(SetAndGetImp.class, 101002);
		  //Add The Condition The Check
		  if(account==null)
		  {
			  System.out.println("The ACcount NotFound");
			  return;
		  }
		  else
		  {
			  tx=sec.beginTransaction();
			  sec.delete(account);
			  tx.commit();
			  System.out.println("The Account Are Deleted Sucessfully");
		  }
	  }
  }
}
