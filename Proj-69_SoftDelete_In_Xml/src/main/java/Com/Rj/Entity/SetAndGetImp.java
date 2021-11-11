package Com.Rj.Entity;

import java.io.Serializable;


import lombok.Data;
@Data
public class SetAndGetImp implements Serializable
{
  private Integer ACNUMBER;
  private String ACHOLDERNAME;
  private Double AMOUNT;
  private String STATUS;

  public SetAndGetImp()
  {
	  System.out.println("SetAndGetImp.SetAndGetImp()");
  }
  
  
}
