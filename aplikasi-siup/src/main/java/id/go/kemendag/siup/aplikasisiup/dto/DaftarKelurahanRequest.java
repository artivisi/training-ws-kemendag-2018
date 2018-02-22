package id.go.kemendag.siup.aplikasisiup.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name = "daftarKelurahanRequest", 
        namespace = "http://kemendag.go.id/webservices/siup")
public class DaftarKelurahanRequest {
    private Pencarian pencarian;
}
