package DjMan.Cj.MainFile;

import org.hibernate.Hibernate;
import org.hibernate.cfg.Configuration;

public class MainClassCallingClass 
{
   
	public static void main(String[] args) 
	{
		//Active The HibernetFramework..
		Configuration cfg=new Configuration();
		
		//Specify The Hibernet Location....
		cfg.configure();
	}
}
