package com.rj.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rj.entity.SetAndImpClass;
import com.rj.utiality.UtialityImplementation;

public class DetailsDoaImple implements IDetailsDao 
{
     //Prepare The Criteria Query-1 com.rj.entity.SetAndImpClass
	private static  String query1="select count(*) from com.rj.entity.SetAndImpClass";
	private static  String query2=" from com.rj.entity.SetAndImpClass";
	
	@Override
	public long GetRecordCount()
	{
		Session sec=UtialityImplementation.getSession();
		long count=0;
		try(sec)
		{
			//Create The Quer Object
			Query query=sec.createQuery(query1);
			count=(long) query.getSingleResult();
		}
        catch (Exception e)
		{
			e.printStackTrace();
		}		
		return count;
	}

	@Override
	public List<SetAndImpClass> getpageData(int StartPostion, int PageSize)
	{
		//Create The Session
		Session sec=UtialityImplementation.getSession();
		try(sec)
		{
			Query query11=sec.createQuery(query2);
			query11.setFirstResult(StartPostion);
			query11.setMaxResults(PageSize);
			List<SetAndImpClass> list=query11.getResultList();
			return list;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
