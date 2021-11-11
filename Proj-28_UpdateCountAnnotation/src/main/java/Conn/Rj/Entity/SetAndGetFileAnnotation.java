package Conn.Rj.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

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
	@Id
    private Long regino;
    @NonNull
    private  Long mobileno;
    @NonNull
    private Boolean prepared; 
    @NonNull
    private String circale;
    @NonNull
    private String coler_tune;
    
    @Version
    private Integer updationsCount;

}
