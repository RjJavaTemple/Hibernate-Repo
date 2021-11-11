package com.rj.Dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rj.entity.BankAccount;
import com.rj.entity.Persion;
import com.rj.utiality.UtialityImplementation;

public class PersionIDetails_Impl implements IPersionDetails 
{
    //Insert Operacation
	@Override
	public void InsertData()
	{ 
		//Create The Sessioin
		Session sec=UtialityImplementation.getSession();
		
		//Add The Child Object
		BankAccount Ba1=new BankAccount("Iccici","Current","Hyd");
		BankAccount Ba2=new BankAccount( "Hdfc","Sallary","Mum");
		
		//Add The Parent Object
		Persion per=new Persion("Chinky","Osera",Map.of("Account1",Ba1,"Account2",Ba2));
		
		//Add The Tranction
		Transaction tx=null;
		try(sec)
		{
			//Begin Tranction
			tx=sec.beginTransaction();
			//Save The Object
			sec.save(per);
			//Copmmit The Data In The Db Table
			tx.commit();
			System.out.println("The Tranction Are Saved SucessFully");
		}
		catch (HibernateException he)
		{
		   he.printStackTrace();
		   if(tx!=null ||tx.getStatus()!=null ||tx.getRollbackOnly())
			   tx.rollback();
		   System.out.println("The Object Input Time Get The Problem");
		}
		catch (Exception e)
		{
		  e.printStackTrace();
		}
	}

	@Override
	public void SelectData() {
		// TODO Auto-generated method stub
		
	}

	/*//Select Operacation
	@Override
	public void SelectData()
	{
		//Create The Session Object
		Session sec=UtialityImplementation.getSession();
		
		try(sec)
		{
			//Create The Query Object
			Query query=sec.createQuery("from com.rj.entity.Persion");
			List<Persion> list=query.getResultList();
			list.forEach(Per->{
				System.out.println("The Persion Details Are:-----------");
				System.out.println(Per);
				System.out.println("---------------------------------------------");
				Map<BankAccount> Account=Per.getAccount();
				Account.forEach(bank->{
					System.out.println("The Bank Details Are::---");
					System.out.println(bank);
				});
			});
		}
	}*/



}
