package Conn.Rj.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ARTIST12")
@Data
public class SetAndGetData implements Serializable 
{
     @Id
     @Column(name="AID")
     private Integer aid;
     
}
