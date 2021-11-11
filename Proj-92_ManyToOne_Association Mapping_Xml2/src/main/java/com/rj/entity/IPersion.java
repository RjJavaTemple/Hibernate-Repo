package com.rj.entity;

import java.util.Set;

public interface IPersion
{
	public void setPerid(Integer Perid);
	public Integer getPerid();
	
	public void setPname(String Pname);
	public String getPname();
	
	public void setPaddress(String Paddress);
	public String getPaddress();
	
	public  Set<BankAccount>getAccount();
	public void setAccount(Set<BankAccount>getAccount);
	
	

}
