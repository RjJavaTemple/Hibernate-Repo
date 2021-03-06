package com.rj.utiality;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UtialityImplitation 
{
	//Create The Static SessionFactory Method
    private static SessionFactory factory;
    
    static
    {
    	 //Active The Hibaername Framework
    	Configuration cfg=new Configuration();
    	
    	//Create The Standard Service Regisry builder
    	StandardServiceRegistryBuilder Builder=new StandardServiceRegistryBuilder();
    	
    	//Create The Standard Service Registery
    	StandardServiceRegistry Registery=Builder.configure("com/rj/cfgs/Person.cfgs.xml").build();
    	
    	//Add The BuildSessionFactory
    	factory=cfg.buildSessionFactory(Registery);
    }
    
    //Get SessionFactory
    public static SessionFactory getSessionFactory()
    {
	      return factory;	
	}
    
    //get The Session
    public static Session getSession()
    {
    	Session sec=null;
    	if(factory!=null)
    	{
    		sec=factory.openSession();
    	}
    	return sec;
    }
    
    //Close The Session factory
    public static void CloseSessionFactory()
    {
    	if(factory!=null)
    		factory.close();
    }
    
    //Close The Session
    public static void CloseSession(Session sec)
    {
    	if(sec!=null)
    		sec.close();
    }
}
