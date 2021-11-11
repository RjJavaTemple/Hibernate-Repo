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
		      //Set The Tranction In teh Query Paramite
		     tx=sec.beginTransaction();
			//Prepare The HQL Query..
		     Query query=sec.createQuery("INSERT into SetAndGetImp2 (ActorId,ActorName,ActorAddress,ActorGender,ActorCurrentFilm) SELECT"
		 	+ " a.ActorId,a.ActorName,a.ActorAddress,a.ActorGender,a.ActorCurrentFilm FROM SetAndGetImp as a where"
		 	+ " a.ActorAddress=?1");
		     //Set In The Query Paramiter
		    query.setParameter(1, "hyd");
		    //Process The Query...
		    int count=query.executeUpdate();
		    //Save The Object In the DataTable
		    tx.commit();
		    System.out.println("NO Of Object Are Affected....."+count);
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
		 
