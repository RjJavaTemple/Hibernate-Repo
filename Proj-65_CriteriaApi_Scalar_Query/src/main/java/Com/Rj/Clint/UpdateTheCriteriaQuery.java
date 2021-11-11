package Com.Rj.Clint;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Com.Rj.Entity.SetAndGetImp;
import Com.Rj.Util.UtialityImplementation;

public class UpdateTheCriteriaQuery 
{
   public static void main(String[] args)
   {
	  //Create The SessionFactory
	   SessionFactory factory=UtialityImplementation.getSessionFactory();
	   //Create The Session
	   Session sec=UtialityImplementation.getSession();
	   //Create The Tranaction
	   Transaction tx=null;
	   
	   try(factory;sec)
	   {
		   //Add The Tranction
		   tx=sec.beginTransaction();
		   //Create The Criteria Builder Object
		   CriteriaBuilder builder=sec.getCriteriaBuilder();
		   //Create The Criteria Query Object
		   CriteriaUpdate<SetAndGetImp> CriQuery=builder.createCriteriaUpdate(SetAndGetImp.class);
		   //Create The Root Object
		   Root<SetAndGetImp> root=CriQuery.from(SetAndGetImp.class);
		 //Create The Logic
		   CriQuery.set(root.get("ActorAddress"), "New-Delhi").where(builder.like(root.get("ActorName"),"R%"));
		   //Create The Query Object
		   Query query=sec.createQuery(CriQuery);
		   //execute The Logic
		   int res=query.executeUpdate();
		   tx.commit();
		   System.out.println("The Quiery Are Update This-->  "+res+"   Time");
	   }
	   catch (HibernateException he)
	   {
		  he.printStackTrace();
		  if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly())
			  tx.rollback();
	  }
	   catch (Exception e)
	   {
		  e.printStackTrace();
	  }
   }
}
