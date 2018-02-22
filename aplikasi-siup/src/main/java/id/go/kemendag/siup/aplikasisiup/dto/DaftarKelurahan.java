package id.go.kemendag.siup.aplikasisiup.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class DaftarKelurahan {
    private List<Kelurahan> kelurahan = new ArrayList<>();
}
