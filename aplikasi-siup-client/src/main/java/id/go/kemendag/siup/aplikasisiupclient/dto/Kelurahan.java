package id.go.kemendag.siup.aplikasisiupclient.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class Kelurahan {
    private Integer id;
    
    @NotNull @NotEmpty
    private String kode;
    @NotNull @NotEmpty
    private String nama;
    @NotNull @NotEmpty
    private String kodepos;
}
