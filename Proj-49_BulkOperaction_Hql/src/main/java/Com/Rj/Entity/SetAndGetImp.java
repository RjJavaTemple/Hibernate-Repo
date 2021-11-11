package Com.Rj.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
public class SetAndGetImp implements Serializable
{
  private Integer SNO;
  private String NAME;
  private String ADDRESS;
  private String PHOTONAME;

  public SetAndGetImp()
  {
	  System.out.println("SetAndGetImp.SetAndGetImp()");
  }
  
  
}
