package Conn.Rj.MainClasas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Rj.Entity.SetterAndGetterMeyhod;
import Conn.Rj.UtillStatic.UtillImplementClassMySql;
import Conn.Rj.UtillStatic.UtillImplementClassSql;

public class TranForeDataMainFile 
{
   public static void main(String[] args)
   {
	   //Create The Sql Object..
		SessionFactory sqlfactory=UtillImplementClassSql.getSessionFactory();
		Session sqlsec=sqlfactory.openSession();
		
		//Create The MySql Object..
		SessionFactory mysqlfactory=UtillImplementClassMySql.getSessionFactory();
		Session mysqlsec=mysqlfactory.openSession();
		
		//Create The Tranction
		Transaction tx=null;
		
		//Using The Try With Resurec
		try(
				//Add The Oll Object.....
				sqlfactory;
				sqlsec;
				mysqlfactory;
				mysqlsec
				)
		{
			//Set The Value What Value Will Be Transfore
			SetterAndGetterMeyhod s=sqlsec.get(SetterAndGetterMeyhod.class, 101);
			if(s!=null)
			{
				tx=mysqlsec.beginTransaction();
				mysqlsec.save(s);
				System.out.println("The Record Are Transfore Sucessfully...............!");
			}
			else
			{
				System.out.println("Record Are NOT Updated..............!");
			}
		}
		catch (HibernateException he)
		{
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
				tx.rollback();
				System.out.println("Plz Contact The Devloper.....!");
			he.printStackTrace();
		}
		catch (Exception e)
		{
			System.out.println("Plz Contact This No->7008943470");
			e.printStackTrace();
		}
   }
}
