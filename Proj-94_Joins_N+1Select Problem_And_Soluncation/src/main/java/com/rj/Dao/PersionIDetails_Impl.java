package com.rj.Dao;


import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rj.entity.BankAccount;
import com.rj.entity.Persion;
import com.rj.utiality.UtialityImplementation;

public  class PersionIDetails_Impl implements IPersionDetails 
{
    //Insert Operacation
	@Override
	public void InsertData()
	{ 
		//Create The Sessioin
		Session sec=UtialityImplementation.getSession();
		
		//Add The Child Object
		BankAccount Ba1=new BankAccount("Sbi","Current","Ckl");
		BankAccount Ba2=new BankAccount( "Icici","saving","Bumbai");
		
		//Add The Parent Object
		Persion per=new Persion("Ranjan","Mirazapur");
		
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
   	public void LodeDataUsingParentHBQBC()
   {
   		//Create The Session Object
	   Session sec=UtialityImplementation.getSession();
	   try(sec)
	   {
		   //Create The Criteria
		   Criteria criteria=sec.createCriteria(Persion.class);
		   criteria.setFetchMode("BankAccount", FetchMode.JOIN);
		   List<Persion> list=criteria.list();
		   list.forEach(per->{
			   System.out.println("Parent"+per);
			   Set<BankAccount> account=per.getAccount();
			   account.forEach(accou->{
				   System.out.println("Child"+accou);
			   });
		   });
	   }
	   catch (HibernateException he)
	   {
		  he.printStackTrace();
	   }
   	}	
    	 
    	 @Override
    	public void LodeDataUsingJPAQBC()
    	 {
    	 	//Create The Session Object
    		 Session sec=UtialityImplementation.getSession();
    		 try(sec)
    		 {
    			 //Create The CriteriaBuilder
    			 CriteriaBuilder builder=sec.getCriteriaBuilder();
    			 //Create The Criteria Query Object
    			 CriteriaQuery<Persion> CtQuery=builder.createQuery(Persion.class);
    			 //Craete The Root Object In The CriteriaQuery
    			 Root<Persion> root=CtQuery.from(Persion.class);
    			 //Join The root Object
    			 //root.join("Account");
    			 //Using The Fetch Inner Join
    			 root.fetch("Account",JoinType.INNER);
    			 //Create The  Query Object
    			 Query query=sec.createQuery(CtQuery);
    			 //Using The List Retrive The Db data
    			 List<Persion> list=query.getResultList();
    			 //Reteive The All Data Use Lambda
    			 list.forEach(row->{
    				 System.out.println("Persion:--->"+row);
    				 //Retrive The Bank Data Using List
    				 Set<BankAccount> Bank=row.getAccount();
    				 //Fonally Retrive The bank data
    				 Bank.forEach(ban->{
    					 System.out.println("Bank-->"+ban);
    				 });
    			 });
    		 }
    		 catch (HibernateException he)
    		 {
				he.printStackTrace();
			}
    	}
    	 
    	 @Override
    	public void LodeDataUsingHQLFetchJoin()
    	 {
    	     //Cretae The Session Object
    		 Session sec=UtialityImplementation.getSession();
    		 try(sec)
    		 {
    			 //Create The Query Object
    			 Query query=sec.createQuery("select p from  Persion p inner join fetch p.Account");
    			 //Retrive daat Using List
    			 List<Persion> list=query.getResultList();
    			 list.forEach(Per->{
    				 System.out.println("Per:::::"+Per);
    				 Set<BankAccount> Bank=Per.getAccount();
    				 Bank.forEach(Banks->{
    					 System.out.println("Bank::"+Bank);
    				 });
    			 });
    		 }
    		 catch (HibernateException he)
    		 {
				he.printStackTrace();
			}
    	}
    	 
    	 @Override
    	public void LodeDataUsingFetchJoin2()
    	 {
    	   //Create The Session Object
    		 Session sec=UtialityImplementation.getSession();
    		 try(sec)
    		 {
    			 //Create The Query Object  NOT WORKIF CONFIGURE THE COLUMN NAME
    			 Query query=sec.createQuery("select p.PId,p.Pname"
    			 		+ "  from  Persion p inner join fetch p.Account ");
    			 //Retrive daat Using List
    			 List<Persion> list=query.getResultList();
    			 list.forEach(Per->{
    				 System.out.println("Per:::::"+Per);
    				 Set<BankAccount> Bank=Per.getAccount();
    				 Bank.forEach(Banks->{
    					 System.out.println("Bank::"+Bank);
    				 });
    			 });
    		 }
    		 catch (HibernateException he)
    		 {
				he.printStackTrace();
			}
    	}
    	 
    	 
    	 
    	 
 }
  