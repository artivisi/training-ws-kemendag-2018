package id.go.kemendag.siup.aplikasisiup.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@Entity @Table(name = "kelurahan")
public class Kelurahan {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull @NotEmpty
    private String kode;
    
    @NotNull @NotEmpty
    private String nama;
    
    @NotNull @NotEmpty
    private String kodepos;
}
