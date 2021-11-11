package Conn.Rj.Entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdClassConfi implements Serializable
{
   private Integer pid;
   private Integer projid;
   
}
