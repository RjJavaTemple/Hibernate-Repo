package Conn.Rj.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

public class SetAndGetClass implements Serializable 
{
	@Id
    private Integer StuId;
    private String StuName;
    private String StuAddress;
    private Double StuMark;
    private String StuSec;
}
