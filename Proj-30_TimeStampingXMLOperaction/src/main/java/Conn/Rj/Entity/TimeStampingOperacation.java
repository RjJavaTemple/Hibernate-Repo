package Conn.Rj.Entity;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TIMESTAMP_ANNOTATION")
public class TimeStampingOperacation 
{
  @Id
  private Integer sid;
  @NonNull
  private String name;
  @NonNull
  private String address;
  @NonNull
  private String gender;
  @NonNull
  private String  section;
  @NonNull
  private String cast;
  
  @CreationTimestamp
  private Timestamp doj;
  
  @UpdateTimestamp
  private Timestamp lastUpdate;
  
  @Version
  private Integer updationcount;
}
