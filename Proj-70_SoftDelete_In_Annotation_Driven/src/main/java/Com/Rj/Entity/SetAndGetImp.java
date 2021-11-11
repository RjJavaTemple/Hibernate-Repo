package Com.Rj.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;


@Entity
@Data
@Table(name = "RJDJMANBANK")
@SQLDelete(sql = "UPDATE RJDJMANBANK SET STATUS='CLOSED' WHERE ACNUMBER=?")
@Where(clause = "STATUS NOT IN ('CLOSED','BLOCKED')")
public class SetAndGetImp implements Serializable
{
	@Id
  private Integer ACNUMBER;
  private String ACHOLDERNAME;
  private Double AMOUNT;
  private String STATUS;

  public SetAndGetImp()
  {
	  System.out.println("SetAndGetImp.SetAndGetImp()");
  }
  
  
}
