package com.rj.dao;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rj.entity.BankCoustmor;
import com.rj.utiality.UtialityImplitation;

public class MethodImplDao implements MethhodInDao
{
     
	@Override
	public void InsertOperacation()
	{
	      //Create Session
		Session  sec=UtialityImplitation.getSession();
		//Add The Tranction
		Transaction tx=null;
		try(sec)
		{
			//Begin Tranction
			tx=sec.beginTransaction();
			//Lode The Object
			BankCoustmor Bank=new BankCoustmor("Ranjan", 70000);
			//Save The Data
			sec.save(Bank);
			//Add The Tranction
			tx.commit();
		}
		catch (HibernateException he)
		{
		   he.printStackTrace();
		   if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly())
			   tx.rollback();
		}
		catch (Exception e)
		{
		   e.printStackTrace();
		}
	}

	@Override
	public String UpdateSalary(int Acno,int Amount)
	{
	    //Create The Session Object
		Session sec=UtialityImplitation.getSession();
		//Add The Tranction
		Transaction tx=null;
		try(sec)
		{
			//Begin Tranction
			tx=sec.beginTransaction();
			Query query=sec.createQuery("update BankCoustmor set Amount=Amount-:amt where PerId=:no");
			query.setParameter("amt",Amount);
			query.setParameter("no", Acno);
			int Result=query.executeUpdate();
			
			
			
			tx.commit();
			System.out.println(Result);
			System.out.println("They Are Updated Are This Time..!");
			
			//data are
			System.out.println(Amount);
			System.out.println(Acno);
		}
		catch (HibernateException he)
		{
		   he.printStackTrace();
		   if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly())
			   tx.rollback();
		}
		return "Unown Exception Are Occure...!";
	}
      
}
