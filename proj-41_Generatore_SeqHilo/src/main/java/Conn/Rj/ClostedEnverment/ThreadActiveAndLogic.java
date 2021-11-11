package Conn.Rj.ClostedEnverment;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetAndGetClass;
import Conn.Rj.Utility.UtialityImplementation;

public class ThreadActiveAndLogic implements Runnable
{

	//Implement the Thread Method As The Run...
	@Override
	public void run() 
	{
		   //Set The Output Screen In The Current Name
			System.out.println("The Thread Name Is:--"+Thread.currentThread().getName());
			try
			{
				//Thread2 Ignore Propose The Write The Program.....
				 if(Thread.currentThread().getName().equalsIgnoreCase("thread2"))
				 {
					 //The Jvm Will Sleep At 40000 Millisecond mince (40 sec)
					 Thread.sleep(40000);
				 }
			}
			//Raising Know-Exception
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			//Create The SessionFactory Object
			SessionFactory factory=UtialityImplementation.getSessionFactory();
			
			//Create The Session Object
			Session sec=UtialityImplementation.getSession();
			
			//Create The Tranction
			Transaction tx=null;
			
			//Create The SetAndGetMethodClass Object
			SetAndGetClass set=new SetAndGetClass();
			set.setStudentName("Rashmi-1");
			set.setStudentAddress("Ckl");
			set.setStdentAvrage(53.0);
			set.setStudentFullMark(600.00);
			set.setStudentSection('A');
			try
			{
			//Save The All Value In IdUnder
			int idvalue=(int)sec.save(set);
			
			//Call The Tranction
			tx=sec.beginTransaction();
			//Commit The Objects In The Data Base
			tx.commit();
			
			System.out.println("The Value Are Saved Sucessfully.......!");
			System.out.println("The Value Are Update->  "+idvalue+"  Time");
			}
			//using known-Exception
			catch (HibernateException he)
			{
				System.out.println("The Object Are Not Save Back To The Java Appilcation");
				he.printStackTrace();
			}
			//Raised Un-Known Exception
			catch (Exception e)
			{
				System.out.println("Problem In Object Input Time....");
				e.printStackTrace();
			}
	}
}
