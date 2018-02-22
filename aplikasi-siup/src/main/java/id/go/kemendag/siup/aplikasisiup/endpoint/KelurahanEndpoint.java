package id.go.kemendag.siup.aplikasisiup.endpoint;

import id.go.kemendag.webservices.siup.DaftarKelurahan;
import id.go.kemendag.webservices.siup.DaftarKelurahanRequest;
import id.go.kemendag.webservices.siup.DaftarKelurahanResponse;
import id.go.kemendag.webservices.siup.Kelurahan;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class KelurahanEndpoint {
    public List<Kelurahan> cari(String nama){
        List<Kelurahan> hasil = new ArrayList<>();
        
        Kelurahan k1 = new Kelurahan();
        k1.setId(new BigInteger("1"));
        k1.setKode("K-001");
        k1.setNama(nama);
        k1.setKodepos(new BigInteger("12300"));
        hasil.add(k1);
        
        Kelurahan k2 = new Kelurahan();
        k2.setId(new BigInteger("2"));
        k2.setKode("K-002");
        k2.setNama(nama);
        k2.setKodepos(new BigInteger("12302"));
        hasil.add(k2);
        
        return hasil;
        
    }
    
    @PayloadRoot(localPart = "daftarKelurahanRequest", namespace = "http://kemendag.go.id/webservices/siup")
    @ResponsePayload
    public DaftarKelurahanResponse cariKelurahan(@RequestPayload DaftarKelurahanRequest request){
        String cariNama = request.getPencarian().getNama();
        System.out.println("Mencari kelurahan dengan nama "+ cariNama);
        
        DaftarKelurahanResponse resp = new DaftarKelurahanResponse();
        DaftarKelurahan soapBody = new DaftarKelurahan();
        soapBody.setKelurahan(cari(cariNama));
        resp.setDaftarKelurahan(soapBody);
        
        return resp;
    }
}
