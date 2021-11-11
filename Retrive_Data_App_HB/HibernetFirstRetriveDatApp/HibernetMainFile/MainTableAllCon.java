
package HibernetMainFile;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernetEntityFiles.StudentTableSetterGetter;

public class MainTableAllCon 
{
  public static void main(String[] args) 
  {
	  //Active The HB Framework.....
		Configuration cfg=new Configuration();
		
		//Sent The File In Xml..
		cfg.configure("HibernetConfigureFile/Hibernet.cfg.xml");
		
		//Create A session Factory...
		SessionFactory factory=cfg.buildSessionFactory();
		
		//Create A session Object...
		Session sec=factory.openSession();
		
		
		try
		{
			//Lode The Object..
			StudentTableSetterGetter stu=sec.get(StudentTableSetterGetter.class, 102);
			if(stu==null)
			{
				System.out.println("The Record Are Not Found");
			}
				else
				{
				System.out.println("The Record Are:---");
				System.out.println(stu.getRollno()+"  "+stu.getName()+"  "+stu.getMark()+"  "+stu.getAddress()+"  "+stu.getAvg()+" "+stu.getStatus());
				}
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
		       //Close The HB Object.....
		        sec.close();
		       factory.close();
		}//finally
  }	//main
}//class
