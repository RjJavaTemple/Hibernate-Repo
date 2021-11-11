package com.rj.Dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rj.entity.Libeary;
import com.rj.entity.Student;
import com.rj.utiality.UtialityImplementation;

public class MethodImpOTO implements IOneToOneMethods
{

	@Override
	public void InsertDataUsingParent()
	{
	  //Craete The Session Object
		Session sec=UtialityImplementation.getSession();
		//Create The Tranction
		Transaction tx=null;
		
		//lode The Parent Class
		Student stu1=new Student("Ranjan-1", "Mum-1");
		
		//Lode The child class
		Libeary lib1=new Libeary("McaCate-1", "Mca-1",LocalDateTime.now());
		
		//Lode The DataUsing
	  stu1.setLiberyDetails(lib1);
	  lib1.setStudentDetails(stu1);
		
		try(sec)
		{
			//Begin tranction
			tx=sec.beginTransaction();
			//Save The Object
			sec.save(stu1);
			//Commit The Data
			tx.commit();
			//See The Console screen
			System.out.println("The Operactiion Are Savde Sucessfully");
		}
		catch (HibernateException he)
		{
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly())
				tx.rollback();
			System.out.println("The Data Input Time Problem");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
 
	@Override
	public void InsertDataUsingChild()
	{
		  //Craete The Session Object
			Session sec=UtialityImplementation.getSession();
			//Create The Tranction
			Transaction tx=null;
			
			//lode The Parent Class
			Student stu1=new Student("Ranjan-2", "Mum-2");
			
			//Lode The child class
			Libeary lib1=new Libeary("McaCate-2", "Mca-2",LocalDateTime.now());
			
			//Lode The DataUsing
		  stu1.setLiberyDetails(lib1);
		  lib1.setStudentDetails(stu1);
			
			try(sec)
			{
				//Begin tranction
				tx=sec.beginTransaction();
				//Save The Object
				sec.save(lib1);
				//Commit The Data
				tx.commit();
				//See The Console screen
				System.out.println("The Operactiion Are Savde Sucessfully");
			}
			catch (HibernateException he)
			{
				he.printStackTrace();
				if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly())
					tx.rollback();
				System.out.println("The Data Input Time Problem");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}		
	}
	
	
	@Override
	public void SelectData()
	{
	  //Create The Session Object
		Session sec=UtialityImplementation.getSession();
		try(sec)
		{
			//Create The Query Object
			Query query=sec.createQuery("from Student");
			//Retrieve The Data Using List Collectiion
			List<Student> Stu=query.getResultList();
			Stu.forEach(Stude->{
				System.out.println("The Student Data Are:---"+Stude);
				Libeary Lib=Stude.getLiberyDetails();
				System.out.println("The Libery Deatils Are::-->"+Lib);
			});
		}
		catch (HibernateException he)
		{
			 he.printStackTrace();
		}
	}
}
