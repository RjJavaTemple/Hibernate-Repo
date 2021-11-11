package com.rj.Dao;

public interface IPersionDetails 
{
   //Create The Insert Method
	public void InsertData();
	
	//Create The Select Method
	public void SelectData();
	
	//DeleteCompliteData
	public void DeleteCompliteDataDbTable1();
	
	//Delete Data In The Child Class Just Cut The Relection
	public void DeleteChildClass2();
	//U Want To Delete Complite Record The Child Table Use The (Cascade="all-delete-oraphan")
	
	//Add The New Data In The Child Object 
	public void AddDataInChildObj3();
	
	//Delete Parent To One Child Object
	public void DeleteOneChildDataInMultipleObject4();
}
