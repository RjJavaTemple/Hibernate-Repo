package Conn.Rj.Thread;

public class MianClientClass 
{
   public static void main(String[] args)
   {
	   ThreadClass tc1=new ThreadClass();
	   ThreadClass tc2=new ThreadClass();
	   ThreadClass tc3=new ThreadClass();
	   
	   Thread t1=new Thread(tc1,"thread1");
	   Thread t2=new Thread(tc2,"thread2");
	   Thread t3=new Thread(tc3,"thread3");
	   
	   t1.start();
	   t2.start();
	   t3.start();
   }
}
