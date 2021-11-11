package com.rj.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rj.entity.product;

import Conn.Rj.Utility.UtilityClassCall;

public class DataWillDirectHeadDataBaseL1Cache
{
   public static void main(String[] args)
   {
	     //Create the sessionFactoty Object
	   SessionFactory factory=UtilityClassCall.getSessionFactory();
	   
	   //Create the session Object
	   Session sec=UtilityClassCall.getSession();
	   
	   //create The Tranction
	   Transaction tx=null;
	   
	   try(
			   factory;
			   sec
			   )
	   {
//             product pro=new product();
//             pro.setPid(101002);
//             pro.setPrice(300.00);
//             pro.setStatus("Not-Ava");
//             pro.setPname("Bukate");
//             pro.setQty(8.03);
//             tx=sec.beginTransaction();
//             int id=(int)sec.save(pro);
//             tx.commit();
             
             
//             product pro=new product(); //That Are Use In the Still The sec.update not ther the data will save not update
//             pro.setPid(101002);
//             pro.setStatus("Not-Ava");
//             pro.setPname("Dunky");
//             tx=sec.beginTransaction();
//             //sec.update(pro);
//             tx.commit();
		   
		   
		   product pro=sec.get(product.class, 101001); //No need to call The sec.not-update 
		   pro.setPname("Mobile");
		   pro.setPrice(311.01);
		   //sec.update(pro);
             System.out.println("The Object Are Saved SucessFully....!");
	   }
	  catch (HibernateException he)
	   {
		  if(tx!=null && tx.getStatus()!=null &&tx.getRollbackOnly())
			  tx.rollback();
		  System.out.println("Input The Data Problem");
		    he.printStackTrace();
	   }
	   catch (Exception e)
	   {
		   System.out.println("DataWillDirectHeadDataBaseL1Cache.main()");
		    e.printStackTrace();
	   }
    }//main
}//class
