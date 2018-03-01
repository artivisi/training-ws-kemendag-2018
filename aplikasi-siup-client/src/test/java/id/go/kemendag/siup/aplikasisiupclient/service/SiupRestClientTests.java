package id.go.kemendag.siup.aplikasisiupclient.service;

import id.go.kemendag.siup.aplikasisiupclient.dto.Kelurahan;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SiupRestClientTests {
    @Autowired private SiupRestClient client;
    
    @Test
    public void testDaftarKelurahan(){
        List<Kelurahan> hasil = client.dataKelurahan();
        for(Kelurahan k : hasil){
            System.out.println("Kode : "+k.getKode());
        }
    }
}
