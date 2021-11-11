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
		Persion per=new Persion("Chinky","Osera",Map.of("Acc1",Ba1,"Acc2",Ba2));
		
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

	//Retrive The Data
     @Override
    public void SelectData()
    {
       //Create The Session 
    	 Session sec=UtialityImplementation.getSession();
    	 try(sec)
    	 {
    		 //Using The Query Object
    		 Query query=sec.createQuery("from Persion");
    		 //Retrive Using List
    		 List<Persion> list=query.getResultList();
    		 //Using Lambda
    		 list.forEach(Per->{
    			 System.out.println("The Persion Data Are");
    			 System.out.println(Per);
    			 Map<String, BankAccount> account=Per.getAccount();
    			 System.out.println("The Bank Data Are");
    			 System.out.println(account);
    		 });
    	 }
    }
     
     @Override
    public void DeleteOneChildOfParent()
    {
       //Create The Session
    	 Session sec=UtialityImplementation.getSession();
    	 //Add The Tranction
    	 Transaction tx=null;
    	 try(sec)
    	 {
    		 //Begin Tranction
    		 tx=sec.beginTransaction();
    		 //Get The Persion Class
    		 Persion per=sec.get(Persion.class, 2);
    		 //LOde The Child Class
    		 Map<String, BankAccount> Bankacc=per.getAccount();
    		 Bankacc.remove("Acc2");
    		 tx.commit();
    		 System.out.println("The Date Are Work SucessFully");
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
