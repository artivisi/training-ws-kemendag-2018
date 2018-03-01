package id.go.kemendag.siup.aplikasisiupclient.service;

import id.go.kemendag.siup.aplikasisiupclient.dto.Kelurahan;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SiupRestClient {
    
    @Value("${server.rest}")
    private String restServer;
    private RestTemplate restTemplate = new RestTemplate();
    private String pathKelurahan = "/api/kelurahan";
    
    public List<Kelurahan> dataKelurahan(){
        ResponseEntity<Kelurahan[]> response = restTemplate.
                getForEntity(restServer + pathKelurahan, Kelurahan[].class);
        return Arrays.asList(response.getBody());
    }

    public Kelurahan cariById(Integer idKelurahan) {
        return restTemplate.getForObject(restServer + pathKelurahan 
                + "/"+idKelurahan, Kelurahan.class);
    }
}
