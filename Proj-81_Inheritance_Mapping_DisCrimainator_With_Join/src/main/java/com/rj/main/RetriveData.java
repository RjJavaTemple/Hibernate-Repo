package com.rj.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rj.entity.Coustmor;
import com.rj.entity.Employee;
import com.rj.entity.Persion;
import com.rj.utiality.UtialityImplementation;

public class RetriveData
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
		   //Retrive The Query 
		   Query query1=sec.createQuery("from Persion");
		   List<Persion> list=query1.getResultList();
		   list.forEach(per->{
			   System.out.println(per);
		   });
		   
		   //Create The Query2 Objec
		   Query query2=sec.createQuery("from Coustmor");
		   List<Coustmor> list1=query2.getResultList();
		   list1.forEach(Cou->{
			   System.out.println(Cou);
		   });
		   
		   //Create The Query3
		   Query query3=sec.createQuery("from Employee");
		   List<Employee> list2=query3.getResultList();
		   list2.forEach(Emp->{
			   System.out.println(Emp);
		   });
	   }
   }
}
