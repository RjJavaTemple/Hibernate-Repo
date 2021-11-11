package Com.Rj.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;



@Entity
@Data
@NamedQuery(name = "Hibernate_Select_Operaction", query = "from SetAndGetImp where ActorId>=?1 and ActorId<=?2")
@NamedQuery(name = "Hibernate_Update_Operaction", query = "update SetAndGetImp set ActorColor=?1 where ActorId=?2")
public class SetAndGetImp implements Serializable
{
  @Id
  @GeneratedValue
  private Integer ActorId;
  private String ActorName;
  private String ActorAddress;
  private Double ActorSalary;
  private String ActorColor;
  private String ActorGender;
  private String ActorCurrentFilm;
  
  public SetAndGetImp()
  {
	  System.out.println("SetAndGetImp.SetAndGetImp()");
  }
  
  
}
