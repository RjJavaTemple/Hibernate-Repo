package Conn.Rj.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Anno_Given_Data")
public class ProjectClassInfo 
{
	@EmbeddedId
     private IdClassConfi id;
	
	@Column(length = 15)
	@Type(type = "string")
     private String pname;
	
	@Column(length = 15)
	@Type(type = "string")
     private String projname;
	
	@Column(length = 15)
	@Type(type = "int")
     private Integer prommber;
     
     
}
