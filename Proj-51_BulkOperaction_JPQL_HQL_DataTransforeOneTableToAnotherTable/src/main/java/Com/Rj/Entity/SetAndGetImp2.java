package Com.Rj.Entity;

import java.io.Serializable;


import lombok.Data;
@Data
public class SetAndGetImp2 implements Serializable
{
  private Integer ActorId;
  private String ActorName;
  private String ActorAddress;
  private Double ActorSalary;
  private String ActorColor;
  private String ActorGender;
  private String ActorCurrentFilm;
  
  public SetAndGetImp2()
  {
	  System.out.println("SetAndGetImp.SetAndGetImp()");
  }
  
  
}
