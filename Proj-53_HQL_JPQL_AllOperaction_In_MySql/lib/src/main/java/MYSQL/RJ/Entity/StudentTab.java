package MYSQL.RJ.Entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentTab implements Serializable
{
  private Integer StuSno;
  private String StuName;
  private String StuAddrs;
  private Double StuMark;
  private Character StuSec;
  private Double StuTotalMark;
}
