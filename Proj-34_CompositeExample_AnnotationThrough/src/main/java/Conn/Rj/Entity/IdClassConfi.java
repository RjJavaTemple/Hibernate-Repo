package Conn.Rj.Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class IdClassConfi implements Serializable
{
	@Type(type="int")
   private Integer pid;
	
	
	@Type(type = "int")
   private Integer projid;
   
}
