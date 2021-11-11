package Mysql.Rj.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Emp_Det")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableClass
{
	@Id
    @GeneratedValue
  private Integer EmpId;
  private String EmpName;
  private String EmpAddress;
  private Double EmpSal;
  private Long EmpMonileNo;
}
