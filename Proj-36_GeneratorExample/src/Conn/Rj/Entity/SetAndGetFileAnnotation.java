package Conn.Rj.Entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class SetAndGetFileAnnotation
{
    private Long regino;
    @NonNull
    private  Long mobileno;
    @NonNull
    private Boolean prepared; 
    @NonNull
    private String circale;
    @NonNull
    private String coler_tune;
    
    
    private Integer updationsCount;

}
