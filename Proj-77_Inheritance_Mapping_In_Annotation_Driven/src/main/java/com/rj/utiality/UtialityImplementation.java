package com.rj.utiality;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UtialityImplementation 
{
    //Create The Session Factory In The Srtarting In The App
	private static SessionFactory factory;
	
	//Use The Static In the App Beacause The The File Are Starting To Running Propouse
	static
	{
		//Active The Hibernate Framewokr
		Configuration cfg=new Configuration();
		//Create The Mordorn Bootraping The Implementation File\
		//Create The StandardServiceRegisteryBuilder
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		//Create The StandardServiceRegistery
		StandardServiceRegistry registery=builder.configure("com/rj/cfgs/Hirbenet.cfg.xml").build();
		//Add The Session Factory As the BuildSessionFactory
		factory=cfg.buildSessionFactory(registery);
	}//Static
	
	//AddThe GetMethod In The Sessionfactory
	public static SessionFactory getSessionFactory()
	{
		return factory;
	}
	
	//Add The Getmethod In The Session
	public static Session geSession()
	{
		Session sec=null;
		if(factory!=null)
		{
			sec=factory.openSession();
		}
		return sec;
	}
	
	//Close The Session Object
	public static void CloseSessionFactory()
	{
		if(factory!=null)
			factory.close();
	}
	
	//Close The Session
	public static void CloseSession(Session sec)
	{
		if(sec!=null)
		{
			sec.close();
		}
	}//Meth
}//class

