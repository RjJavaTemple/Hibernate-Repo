package com.rj.servlet;

import java.util.List;

import com.rj.dao.DetailsDoaImple;
import com.rj.dao.IDetailsDao;
import com.rj.entity.SetAndImpClass;

public class DetailsmanagementService implements IDetaildService 
{

	//Create The Interface Object
	IDetailsDao doa;
	
	public DetailsmanagementService()
	{
		doa=new DetailsDoaImple();
	}
	
	@Override
	public int getPagessCount(int PageSize) 
	{
		//get The Record In The Doa Interface
	  	long RecordCount=doa.GetRecordCount();
	  	int pagesCount=(int) (RecordCount/PageSize);
	  	pagesCount=RecordCount%PageSize==0?pagesCount:++pagesCount;
	  	
	  	//Return The Data
	  	return pagesCount;
	}

	@Override
	public List<SetAndImpClass> GetReportPageData(int pageNo, int PageSize)
	{
	   //Declare The Start Postion
		int StartPos=(pageNo*PageSize)-PageSize;
		//Use The Doa
		List<SetAndImpClass> list=doa.getpageData(StartPos, PageSize);
		return list;
	}
}
