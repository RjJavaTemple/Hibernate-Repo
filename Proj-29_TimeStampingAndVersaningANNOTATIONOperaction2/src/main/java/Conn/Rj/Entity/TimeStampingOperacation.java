package Conn.Rj.Entity;


import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class TimeStampingOperacation 
{
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
  
  private Timestamp lastUpdated;
}
