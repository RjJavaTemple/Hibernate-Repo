package com.rj.Dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rj.entity.DrivingLience;
import com.rj.entity.Persion;
import com.rj.utiality.UtialityImplementation;

public class OneToOneFk_Col_Impl implements IMethodImplement
{

	@Override
	public void InsertDataUsingChild()
	{
	  //Create The Session Object
		Session sec=UtialityImplementation.getSession();
		//Create The Tranction Object
		Transaction tx=null;
		//Add Teh Parent Object Insert Data
		Persion Per=new Persion("Rashmi", "Chandikhole");
		//Add The Child Class Object Insert Data
		DrivingLience Dl=new DrivingLience("Four-Whiler", LocalDateTime.of(2020,10,21,10,33,44), Per);
		try(sec)
		{
			//Begin Tranction
			tx=sec.beginTransaction();
			//Save The Object
			sec.save(Dl);
			//Commit The Data In Db Table
			tx.commit();
			System.out.println("The Object Save Sucess....");
		}
		catch (HibernateException he)
		{
			 he.printStackTrace();
			 if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				 tx.rollback();
			 System.out.println("The Object InputTime Problem Occure..");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
@Override
	public void SelectDataUsingChild()
    {
	   //Create The Session Object
	   Session sec=UtialityImplementation.getSession();
	   try(sec)
	   {
		   //Create The Query Object
		   Query query=sec.createQuery("from DrivingLience");
		   List<DrivingLience> Dl=query.getResultList();
		   //Retrive The Data Using Lambda
		   Dl.forEach(Dlre->{
			   System.out.println("Parent::"+Dlre);
			   //Add The Parent Class
			   Persion Per=Dlre.getLincenceHolder();
			   System.out.println("Parent::"+Per);
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
