package com.rj.main;



import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rj.entity.StudentDetails;
import com.rj.utiality.UtialityImplementation;

public class InsertDataa 
{
   public static void main(String[] args)
   {
	   //Add The SessionFactory
	   SessionFactory factory=UtialityImplementation.getSessionFactory();
	   
	   //Add the Session
	   Session sec=UtialityImplementation.getSession();
	   
	   //Add The Tranction Hear
	   Transaction tx=null;
	   
	   //Use The Try Cat In Java-9
	   try(
			   factory;
			   sec
			   )
	   {
		   //Create The Begin Tranction
		   tx=sec.beginTransaction();
		   
		   //Creat The Student Object And Insert The data
		   StudentDetails sd1=new StudentDetails();
		   sd1.setSname("Ranjan");
		   sd1.setFrends(List.of("Chintu","Chinky","Renu","Sharmista"));
		   sd1.setPhoneNo(Set.of(2345678l,98765432l,9875645678l,65748354l));
		   sd1.setIdCirtificate(Map.of("AddharNo",1234567l,"PanNo",65438765l,"Greenno",8465735647l));
		   
		   StudentDetails sd2=new StudentDetails();
		   sd2.setSname("Ranjan");
		   sd2.setFrends(List.of("Chintu","Chinky","Renu","Sharmista"));
		   sd2.setPhoneNo(Set.of(2345678l,98765432l,9875645678l,65748354l));
		   sd2.setIdCirtificate(Map.of("AddharNo",1234567l,"PanNo",65438765l,"Greenno",8465735647l));
		   
		   
		   StudentDetails sd3=new StudentDetails();
		   sd3.setSname("Ranjan");
		   sd3.setFrends(List.of("Chintu","Chinky","Renu","Sharmista"));
		   sd3.setPhoneNo(Set.of(2345678l,98765432l,9875645678l,65748354l));
		   sd3.setIdCirtificate(Map.of("AddharNo",1234567l,"PanNo",65438765l,"Greenno",8465735647l));
		   
		   //Save The Three Object
		   sec.save(sd1);
		   sec.save(sd2);
		   sec.save(sd3);
		   
		   //Commit The Data
		   tx.commit();
		   
		   System.out.println("The Data Are Saved SucessFully");
		   
	   }
	   catch (HibernateException he)
	   {
		  he.printStackTrace();
	   }
	   catch (Exception e)
	   {
		  e.printStackTrace();
	   }
   }//main
}//class
