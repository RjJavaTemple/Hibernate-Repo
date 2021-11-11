package com.rj.Dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rj.entity.Doctor;
import com.rj.entity.Patitent;
import com.rj.utiality.UtialityImplementation;

public class ImplOfMTMMethods implements IManyToManyAssociationMethod
{

	@Override
	public void InsertDataUsingParent()
	{
	    //Create The Seession 
		Session sec=UtialityImplementation.getSession();
		//Add The Tranction
		Transaction tx=null;
		
		//Lode The Parent Class
		Doctor doc1=new Doctor("Chinky", "Dyning");
		Doctor doc2=new Doctor("Rashmi", "MBBS");
		
		//Lode The Parent Class
		Patitent pt1=new Patitent("Ranjan", "Jhada");
		Patitent pt2=new Patitent("Tikili", "PetagudGud");
		Patitent pt3=new Patitent("Gudia", "Motapa");
		Patitent pt4=new Patitent("Bubuna", "Patala");
		Patitent pt5=new Patitent("Tikila", "ChotoChua");
		
		//Add The Child To Parent Object
		doc1.setPatient(List.of(pt1,pt3,pt4));
		doc2.setPatient(List.of(pt1,pt2,pt4,pt5));
		
		//Add Parent Under Child Object
		pt1.setDoctor(List.of(doc1,doc2));
		pt2.setDoctor(List.of(doc2));
		pt3.setDoctor(List.of(doc1));
		pt4.setDoctor(List.of(doc1,doc2));
		pt5.setDoctor(List.of(doc2));
		try(sec)
		{
			//begin Tranction
			tx=sec.beginTransaction();
			//Save The Parent
			sec.save(doc1);
			sec.save(doc2);
			//Commit The Db Table
			tx.commit();
			System.out.println("The Operacation Are Sucess...!");
		}
		catch (HibernateException he)
		{
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				tx.rollback();
			System.out.println("The Object Insert Time Problem");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void InsertDataUsingChild()
	{
		//Create The Seession 
				Session sec=UtialityImplementation.getSession();
				//Add The Tranction
				Transaction tx=null;
				
				//Lode The Parent Class
				Doctor doc1=new Doctor("RashmiRek", "Dyning");
				Doctor doc2=new Doctor("RashmiRanjan", "MBBS");
				
				//Lode The Parent Class
				Patitent pt1=new Patitent("Ranjan1", "Jhada-A");
				Patitent pt2=new Patitent("Tikili1", "PetagudGud-A");
				Patitent pt3=new Patitent("Gudia1", "Motapa-A");
				Patitent pt4=new Patitent("Bubuna1", "Patala-A");
				Patitent pt5=new Patitent("Tikila1", "ChotoChua-A");
				
				//Add The Child To Parent Object
				doc1.setPatient(List.of(pt1,pt3,pt4));
				doc2.setPatient(List.of(pt1,pt2,pt4,pt5));
				
				//Add Parent Under Child Object
				pt1.setDoctor(List.of(doc1,doc2));
				pt2.setDoctor(List.of(doc2));
				pt3.setDoctor(List.of(doc1));
				pt4.setDoctor(List.of(doc1,doc2));
				pt5.setDoctor(List.of(doc2));
				try(sec)
				{
					//begin Tranction
					tx=sec.beginTransaction();
					//Save The Parent
					sec.save(pt1);
					sec.save(pt2);
					sec.save(pt3);
					sec.save(pt4);
					sec.save(pt5);
					//Commit The Db Table
					tx.commit();
					System.out.println("The Operacation Are Sucess...!");
				}
				catch (HibernateException he)
				{
					he.printStackTrace();
					if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
						tx.rollback();
					System.out.println("The Object Insert Time Problem");
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
		
	}

	
	@Override
	public void SelectTest()
	{
	  //Create The Session object
		Session sec=UtialityImplementation.getSession();
		try(sec)
		{
			//Create The Query Object
			Query query=sec.createQuery("from Doctor");
			//Retrive The Data Using Listy Ans lambada ForEach
			List<Doctor> list=query.getResultList();
			list.forEach(Doc->{
				System.out.println("The Doc data:--"+Doc);
				});
		}
	}
}
