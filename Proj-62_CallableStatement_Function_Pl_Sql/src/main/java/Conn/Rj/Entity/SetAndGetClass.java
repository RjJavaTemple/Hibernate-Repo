package Conn.Rj.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class SetAndGetClass implements Serializable 
{
    private Integer ActorId;
    private String ActorName;
    private String ActorAddress;
    private Double ActorSalary;
    private String ActorColor;
    private String ActorGender;
    private String ActorCurrentFilm;
}
