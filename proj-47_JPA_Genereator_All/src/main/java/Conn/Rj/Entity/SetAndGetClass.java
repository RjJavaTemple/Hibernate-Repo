package Conn.Rj.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Data
@Table(name = "JPA_Generator_Tab")
public class SetAndGetClass 
{
	//All Jpa Generator
	//Identity Generator
	/*@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Id*/
	
	
	//Sequence Generator
	/*	@GeneratedValue(strategy = GenerationType.SEQUENCE) */
	
	
	//Generator In Custom Sequence
	/*@SequenceGenerator(name = "gen1",sequenceName = "HIBERNATE_SEQUENCE1",
			initialValue = 600,allocationSize = 5
			)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)*/
	
	
	//Default Sequence Generator
	/*@SequenceGenerator(name = "gen1",sequenceName = "HIBERNATE_SEQUENCE1")
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE) *///Increment 50
	
	
	//Create The Custom Table Generator
	/*@TableGenerator(name = "gen1",pkColumnName = "ID_COL",table = "ID_TAB",pkColumnValue = "StuSno"
			,valueColumnName = "VAL_COL",initialValue = 200,allocationSize = 2
			)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.TABLE)*/
	
	
	//Create the NormalFlow Table Jpa Genarator
	/*@GeneratedValue(generator = "gen1",strategy = GenerationType.TABLE)*/ //Increment 50
	
	//Create The Normal-Flow Auto Jpa Generator
	/*	@GeneratedValue(generator = "gen2",strategy = GenerationType.AUTO)*/
	
	
	//Create The Custom Auto Generator
	@SequenceGenerator(name = "gen2",sequenceName = "JPA_PID_SEQ2",initialValue = 200,allocationSize = 10)
	@GeneratedValue(generator = "gen2",strategy = GenerationType.AUTO)
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
