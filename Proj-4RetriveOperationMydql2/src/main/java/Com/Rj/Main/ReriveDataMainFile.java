package Com.Rj.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Com.Rj.Entity.Set_Value_SetterAndGetter;
import Com.Rj.Utillity.UtilityAllConnection;

public class ReriveDataMainFile 
{
  public static void main(String[] args)
  {
	  //Define The SessionFactory and session
	  SessionFactory factory=UtilityAllConnection.getSessionFactory();
	  Session sec=UtilityAllConnection.getSession();
	  try(
			  factory;
			  sec
			  )
	  {
		  //Retrive The Value..
		  Set_Value_SetterAndGetter set=sec.get(Set_Value_SetterAndGetter.class, 100);
		  if(set==null)
			  System.out.println("No Record Are Found...........!");
		  else
		  {
			  System.out.println("The Record Are:-------!");
			  System.out.println("The Student RollNo Are:-"+set.getSno()+"\n The Student Name Are:- "+set.getName()+
					  "\n The Student Address Are:-"+set.getAddress()+"\n  The Student Mark Are:-"+set.getMark()+
					  "\n The Student Avrage Are:- "+set.getAvg()+"\n The Student Grade Is:-"+set.getGrade());
		  }
	  }
  }
}
