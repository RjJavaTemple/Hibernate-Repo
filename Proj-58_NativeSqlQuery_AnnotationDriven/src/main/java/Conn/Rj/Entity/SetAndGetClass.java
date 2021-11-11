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
@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQuery(name="UPDAET_QUERY",query=" UPDATE STUDENT SET STUADDRESS=:NEWADD WHERE STUID=:IDNAME")

@NamedNativeQuery(name = "SELECT_OPERACATION1" , 
    query="SELECT StuId,StuName,StuAddress,StuMark,StuSec FROM Student WHERE StuAddress=?",
                                    resultClass = SetAndGetClass.class)

public class SetAndGetClass implements Serializable 
{
	@Id
    private Integer StuId;
    private String StuName;
    private String StuAddress;
    private Double StuMark;
    private String StuSec;
}
