package com.rj.servlet;

import java.util.List;

import com.rj.entity.SetAndImpClass;

public interface IDetaildService 
{
  public int getPagessCount(int PageSize);
  public List<SetAndImpClass> GetReportPageData(int pageNo,int PageSize);
}
