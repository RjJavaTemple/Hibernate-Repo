package Conn.Rj.Entity;

import lombok.Data;
import lombok.NonNull;

@Data
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
