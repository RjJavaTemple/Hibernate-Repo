package com.rj.Dao;


import java.util.Set;
import org.hibernate.HibernateException;
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
		Persion per=new Persion("Chintu","Mirzapur");
		
		//Map Parent Object To Child
		Ba1.setPersion(per);
		Ba2.setPersion(per);
		
		//Map Parent Object To Child Objct
		per.setAccount( Set.of(Ba1,Ba2));
		
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

	@Override
	public void InDataOTm_By_Dir() {
		// TODO Auto-generated method stub
		
	}

	
    	 
    	 
    }
     
    