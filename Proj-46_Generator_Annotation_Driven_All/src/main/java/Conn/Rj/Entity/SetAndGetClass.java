package Conn.Rj.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Data
@Table(name = "Student_123")
public class SetAndGetClass 
{
	//This Is Increment Story
	/*@GenericGenerator(name = "gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")*/
	
	//This is Identity Story
	/*@GenericGenerator(name = "gen1",strategy = "identity")
	@GeneratedValue(generator = "gen1")*/
	
	//This is Sequence Story.. (Normal Flow)
	/*@GenericGenerator(name = "gen1",strategy = "sequence")
	@GeneratedValue(generator = "gen1")*/

	
	//This is Sequence Story.. (UserDefine Flow)
	/*@GenericGenerator(name = "gen1",strategy = "sequence",
			  parameters = @Parameter(name = "sequence_name", value = "STU_123_SEQ")
			)
	@GeneratedValue(generator = "gen1")*/

	
	//This is Sequence Story.. (UserDefine Own Insert Value And Own Increment Value Flow)
	/*@GenericGenerator(name = "gen1",strategy = "sequence",
			  parameters = { @Parameter(name = "sequence_name", value = "STU_123_SEQ1"),
			   @Parameter(name = "initial_value", value = "300"),
			   @Parameter(name = "increment_size", value = "2")
	}
			)
	@GeneratedValue(generator = "gen1")*/
	
	
	//The seqHilo Genaratoe Story
	@GenericGenerator(name = "gen1",strategy = "seqhilo",
			  parameters = { @Parameter(name = "sequence_name", value = "STU_123_SEQ2"),
			   @Parameter(name = "initial_value", value = "300"),
			   @Parameter(name = "max_lo", value = "3")//Not Working Properly
	}
			)
	@GeneratedValue(generator = "gen1")

	 
	@Id
	private Integer StuSno;
	@Column(length = 20)
	private String StudentName;
	@Column(length = 20)
	private String StudentAddress;
	@Column(length = 20)
	private Double StdentAvrage;
	@Column(length = 20)
	private Double StudentFullMark;
	@Column(length = 20)
	private Character StudentSection;
	
}
