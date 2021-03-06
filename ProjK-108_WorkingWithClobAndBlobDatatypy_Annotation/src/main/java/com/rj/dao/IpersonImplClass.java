package com.rj.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rj.entity.Person;
import com.rj.utiality.UtialityImplitation;

public class IpersonImplClass implements IpersonMethod
{

	@Override
	public void SaveData() 
	{
	      //Create The Session Object
		Session sec=UtialityImplitation.getSession();
		//Add The Tranction
		Transaction tx=null;
		//Set the Resume Are Person
		File file=new File("E:\\CORE JAVA\\interview qus\\basic of core java.txt");
		try(sec)
		{
			//Set the Photo Are Persioon
			FileInputStream Fis=new FileInputStream("C:\\Users\\Rashmiranjan Jena\\Downloads\\hy-3.jpg");
			//Set The Resume Are Person
			FileReader Readre=new FileReader(file);
			//Begin Tranction
			tx=sec.beginTransaction();
			//Create The Persion Object
			Person Per=new Person();
			Per.setPname("Ranjan");
			Per.setPaddress("Chandikhole");
			//Insert The Photo Content
			byte[] PhotoData=new byte[Fis.available()];
			Fis.read(PhotoData);
			Per.setPhoto(PhotoData);
			//Insert The Resume Data In The Db Table
			char[] ResumeData=new char[(int) file.length()];
			Readre.read(ResumeData);
			Per.setResume(ResumeData);
			
			//Save The Object In The Db table
			sec.save(Per);
			//Commit The Code
			tx.commit();
			System.out.println("The Operaction Sucess.....!");
		}
		catch (HibernateException he)
		{
		   he.printStackTrace();
		   if(tx!=null ||tx.getStatus()!=null ||tx.getRollbackOnly())
			   tx.rollback();
		   System.out.println("The Data Input Time Problem");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	
	@Override
	public void SelectData() 
	{
	   	//Create The Session 
		Session sec=UtialityImplitation.getSession();
		try(sec)
		{
			//get The Data
			Person Per=sec.get(Person.class, 1);
			//get The Pname Paddress And Pid
			System.out.println("The Persion Id:-"+Per.getPid());
			System.out.println("The Persion Name:-"+Per.getPname());
			System.out.println("The Persion Address:-"+Per.getPaddress());
			
			//Get The Pesion Photo And Resume
			//Photo
			FileOutputStream Fos=new FileOutputStream("Hibysha.jpg");
			byte[] PhotoDat=Per.getPhoto();
			Fos.write(PhotoDat);
			//Resume
			FileWriter Writer=new FileWriter("Resume.txt");
			char[] ResumeData=Per.getResume();
			Writer.write(ResumeData);
			System.out.println("Data Retive Sucess See The Project Under Say Refresh Once");
		}
		catch (HibernateException he)
		{
			he.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
