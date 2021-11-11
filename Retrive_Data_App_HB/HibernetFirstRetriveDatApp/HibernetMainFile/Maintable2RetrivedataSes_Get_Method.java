package HibernetMainFile;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernetEntityFiles.StudentTableSetterGetter;

public class Maintable2RetrivedataSes_Get_Method 
{
 public static void main(String[] args)
 {
	 //Active The Hibernet Framework
		Configuration cfg=new Configuration();
		
		//configure the HiberNetFramework
		cfg.configure("HibernetConfigureFile/Hibernet.cfg.xml");
		 
		 //Create A session Factory
		 SessionFactory sef=cfg.buildSessionFactory();
		 
		 //Create A Session Object
		 Session sc=sef.openSession();
		 
		try
		 {
			 //Lode The Setter and gette method object
			 StudentTableSetterGetter stu=sc.load(StudentTableSetterGetter.class, 102);
				 //getRollno()+getName()+getMark()+getAddress()+getAvg()+" "+getStatus()
				 System.out.println(stu.getRollno()+"  "+stu.getName()+"  "+stu.getMark()+"  "+stu.getAddress()+"  "+stu.getAvg()+" "+stu.getStatus());
		   }
		catch (HibernateException he)
		{
			he.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Close The Object
			sef.close();
			sc.close();
		}
	}
  }


