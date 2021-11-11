package Mysql.Rj.Utilty;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UtialityImplementClass 
{
    private static  SessionFactory factory;
    static
    {
    	//Active The Hb Framework
    	Configuration cfg=new Configuration();
    	
    	//Work With Mordern Approchs
    	// Create The StandardServiceRegistryBuilder Object.
    	StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
    	
    	//Create StandardServiceRegistry Object
    	StandardServiceRegistry registery=builder.configure("Mysql/Rj/Cfgs/Hibernate.cfgs.xml").build();
    	
    	//Configure The BuiltSessionFactory 
    	factory=cfg.buildSessionFactory(registery);
    }//static
    
    //Get The SessionFactory
    public static SessionFactory getSessionFactory()
    {
    	return factory;
    }
    
    //get The Seeeion 
    public static Session getSession()
    {
    	Session sec=null;
    	if(factory!=null)
    	{
    		sec=factory.openSession();
    	}
    	return sec;
    }
    
    //Close The sessionFactory
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
}//Class
