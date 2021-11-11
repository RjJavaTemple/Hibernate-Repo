package com.rj.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Try.Re.entity.product;


public class Save_object_test 
{
 public static void main(String[] args) 
 {
    //Active The HB f/w
	  Configuration cfg=new Configuration();
	  
	  //Spesyfiy The hibernrt File or location....
	  cfg.configure("com/rj/cfgs/hibernet.cfg.xml");
	  
	  //Create A Hb Session Factor Object....
	    SessionFactory factory=cfg.buildSessionFactory();
	    
	    //create SEssion Object....
	      Session sec=factory.openSession();
	      
	      //Prepare Entity Class Object In Data......
	      product n=new product();
	      n.setPid(101003);
	      n.setPname("X_Phone");
	      n.setPrice(10000.00);
	      n.setQty(22.31);
	      n.setStatus("Avalable");
	      
	      //Save The Object............
	      Transaction tx=null;
	      boolean flag=false;
	      
	      try
	      {
	    	  tx=sec.beginTransaction();
	    	  sec.save(n);
	    	  flag=true;
	    	  
	      }
	      catch (HibernateException he) 
	      {
			he.printStackTrace();
			flag=false;
		  }
	      catch (Exception e) 
	      {
			e.printStackTrace();
		  }
	      finally
	      {
	    	  if(flag)
	    	  {
	    		  tx.commit();
	    		  System.out.println("Object Are Saved(Recore Are INserted....)");
	    	  }
	    	  else
	    	  {
	    		  tx.rollback();
	    		  System.out.println("Object Are Not Saved(Record Are Not Insereted....)");
	    	  }//else
	    	  
	    	  //Close The HB Object.....
	    	  sec.close();
	    	  factory.close();
	    	  
	    	  
	      }//finally
    }//main
}//class
