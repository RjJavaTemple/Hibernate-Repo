package com.rj.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rj.entity.Dtails;
import com.rj.entity.Persion;
import com.rj.utiality.UtialityImplementation;import oracle.net.aso.f;

public class RetriveTheData 
{
   public static void main(String[] args)
   {
	  //Create The SessionFactory
	   SessionFactory factory=UtialityImplementation.getSessionFactory();
	   //Create The Session
	   Session sec=UtialityImplementation.geSession();
	   try(factory;
			   sec
			   )
	   {
		   //Retrive The Data In The Query Object
		   Query query=sec.createQuery("from Persion");
		   //Retrive Using The List Object
		   List<Persion> list=query.getResultList();
		   //Using The Lambda
		   list.forEach(persion->{
			   System.out.println(persion);
		   });
		   
		   System.out.println("---------------------------------------------------------------------");
		   System.out.println("Using The Condition");
		   Query query1=sec.createQuery("from Persion where Details.Degs=?1");
		   query1.setParameter(1, "Manager");
		   //Retrive Using The List Object
		   List<Persion> list1=query1.getResultList();
		   //Using The Lambda
		   list1.forEach(persion->{
			   System.out.println(persion);
			   Dtails det=persion.getDetails();
			   System.out.println(det);
		   });
	   }
   }
}
