package Conn.Rj.ClostedEnverment;

public class MianClientApp2 
{
  public static void main(String[] args)
  {
	  //Call The Three 3 Time In The Application 
       ThreadActiveAndLogic tl1=new ThreadActiveAndLogic();  
       ThreadActiveAndLogic tl2=new ThreadActiveAndLogic();  
       ThreadActiveAndLogic tl3=new ThreadActiveAndLogic();
       
       
       //Set the Thread Class Under Implement Thread UsetDefine ThreadActiveAndLogic class
       Thread t1=new Thread(tl1,"thread1");
       Thread t2=new Thread(tl2,"thread2");
       Thread t3=new Thread(tl3,"thread3");
       
       //Start The Thread....
       t1.start();
       t2.start();
       t3.start();
  }
}
