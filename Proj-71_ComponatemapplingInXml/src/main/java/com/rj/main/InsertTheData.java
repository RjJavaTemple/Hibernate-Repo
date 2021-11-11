package com.rj.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rj.entity.Dtails;
import com.rj.entity.Persion;
import com.rj.utiality.UtialityImplementation;

import lombok.NonNull;

public class InsertTheData 
{
  public static void main(String[] args)
  {
	  //Creatr The Session factory Object
	  SessionFactory factory=UtialityImplementation.getSessionFactory();
	  //Create The Session 
	  Session sec=UtialityImplementation.geSession();
	  //Cret The Tanaction Object
	  Transaction tx=null;
	  //Using Try Ctch In  The Java 9 Onword
	  try(factory;
			  sec
			  )
	  {
		  //Add The Tranction Hear
		  tx=sec.beginTransaction();
		  //Add The Details
       Dtails details=new Dtails("Manager-3", "RJCOM", 101, 10000.0);
       //Add The Main Data
       Persion per=new Persion("Ranjan-4", "Mirzapur", "Black", details);
       //Save The Data Data Base
       int idval=(int) sec.save(per);
       //Commit TheData In The Db Table
       tx.commit();
       System.out.println("The Record Of Affetct Of The Data"+idval);
       System.out.println("The Record Are Save Sucessfully.............!");
	  }
	  catch (HibernateException he)
	  {
		he.printStackTrace();
		if(tx!=null || tx.getStatus()!=null|| tx.getRollbackOnly())
			tx.rollback();
		System.out.println("The Object Input Time Problem Occure In The App");
	 }
	  catch (Exception e)
	  {
		  e.printStackTrace();
	  }
   }
}
