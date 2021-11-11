package Conn.Rj.Entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SetAndGetClass implements Serializable 
{
    private Integer StuId;
    private String StuName;
    private String StuAddress;
    private Double StuMark;
    private String StuSec;
}
