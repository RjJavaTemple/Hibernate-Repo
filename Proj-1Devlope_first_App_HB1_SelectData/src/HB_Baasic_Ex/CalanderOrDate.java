package HB_Baasic_Ex;

import java.util.Calendar;

public class CalanderOrDate 
{
   public static void main(String[] args) throws Exception
   {
	   
	   //Create The Connection In java Date Format....
	   Class clazz1=Class.forName("java.util.Date");
	   System.out.println(clazz1);
	   
	   
	   System.out.println("--------------------------------------");
	   
	   //Create A Calander Object
	   java.util.Calendar cal=Calendar.getInstance();
	   Class cazz2=cal.getClass();
	   System.out.println(cazz2);
	   
	   System.out.println("--------------------------------------");
        
	   //Lode The Object Class In the javaobjetc..
       Object obj=clazz1.newInstance();
       System.out.println(obj);
   }
}
