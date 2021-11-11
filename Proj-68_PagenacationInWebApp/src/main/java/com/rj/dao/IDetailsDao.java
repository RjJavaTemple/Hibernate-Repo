package com.rj.dao;

import java.util.List;

import com.rj.entity.SetAndImpClass;

public interface IDetailsDao
{
   public long GetRecordCount();
   public List<SetAndImpClass> getpageData(int StartPostion,int PageSize);
   
}
