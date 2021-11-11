package com.rj.Dao;

import java.util.List;
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
		Persion per=new Persion("Chinky","Osera",List.of(Ba1,Ba2));
		
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

	//Select Operacation
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
				List<BankAccount> Account=Per.getAccount();
				Account.forEach(bank->{
					System.out.println("The Bank Details Are::---");
					System.out.println(bank);
				});
			});
		}
	}

	//Delete The Complite Data In The Parent And Child Class...
	@Override
	public void DeleteCompliteDataDbTable1()
	{
		//Create The Session Object
		Session sec=UtialityImplementation.getSession();
		//Add The Tranction
		Transaction tx=null;
		try(sec)
		{
			//Begin Tranction
			tx=sec.beginTransaction();
			//Lode The Parent Object
			Persion per=sec.get(Persion.class,2);
			//Save The Object
			sec.delete(per);
			//Commit The Code
			tx.commit();
			System.out.println("The Data Are Saved Sucessfully....!");
		}
		catch (HibernateException he)
		{
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly())
				tx.rollback();
			System.out.println("The Object Delecation Time Problem Are Occure..");
		}
		catch (Exception e)
		{
		  e.printStackTrace();
		}
	}

	@Override
	public void DeleteChildClass2()
	{
		//Create The Session Object
				Session sec=UtialityImplementation.getSession();
				//Add The Tranction
				Transaction tx=null;
				try(sec)
				{
					//Begin Tranction
					tx=sec.beginTransaction();
					//Lode The Parent Object
					Persion per=sec.get(Persion.class,2);
					//Lode The Chhild Parms
					List<BankAccount> bank=per.getAccount();
					bank.removeAll(bank);
					//Commit The Code
					tx.commit();
					System.out.println("The Data Are Saved Sucessfully....!");
				}
				catch (HibernateException he)
				{
					he.printStackTrace();
					if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly())
						tx.rollback();
					System.out.println("The Object Delecation Time Problem Are Occure..");
				}
				catch (Exception e)
				{
				  e.printStackTrace();
				}
	}

	@Override
	public void AddDataInChildObj3()
	{
		//Create The Session Object
		Session sec=UtialityImplementation.getSession();
		//Add The Tranction
		Transaction tx=null;
		try(sec)
		{
			//Begin Tranction
			tx=sec.beginTransaction();
			//Lode The Parent Object
			Persion per=sec.get(Persion.class,2);
			//Lode The Chhild Parms
			List<BankAccount> bank=per.getAccount();
			//Create A New Child
			BankAccount ba=new BankAccount("RanjanBank", "Current", "Chandigad");
			bank.add(ba);
			//Commit The Code
			tx.commit();
			System.out.println("The Data Are Saved Sucessfully....!");
		}
		catch (HibernateException he)
		{
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly())
				tx.rollback();
			System.out.println("The Object Delecation Time Problem Are Occure..");
		}
		catch (Exception e)
		{
		  e.printStackTrace();
		}
	}

	@Override
	public void DeleteOneChildDataInMultipleObject4()
	{
		//Create The Session Object
				Session sec=UtialityImplementation.getSession();
				//Add The Tranction
				Transaction tx=null;
				try(sec)
				{
					//Begin Tranction
					tx=sec.beginTransaction();
					//Lode The Parent Object
					Persion per=sec.get(Persion.class,2);
					//Lode The Chhild Parms
					List<BankAccount> bank=per.getAccount();
					//Create A New Child
					BankAccount ba=sec.get(BankAccount.class, 101025l);
					bank.remove(ba);
					//Commit The Code
					tx.commit();
					System.out.println("The Data Are Saved Sucessfully....!");
				}
				catch (HibernateException he)
				{
					he.printStackTrace();
					if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly())
						tx.rollback();
					System.out.println("The Object Delecation Time Problem Are Occure..");
				}
				catch (Exception e)
				{
				  e.printStackTrace();
				}
	}

}
