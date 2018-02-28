package id.go.kemendag.siup.aplikasisiup.controller;

import id.go.kemendag.siup.aplikasisiup.dao.KelurahanDao;
import id.go.kemendag.siup.aplikasisiup.entity.Kelurahan;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class KelurahanApiController {
    @Autowired
    private KelurahanDao kelurahanDao;
    
    @GetMapping("/api/kelurahan")
    @ResponseBody
    public Page<Kelurahan> dataKelurahan(Pageable page){
        return kelurahanDao.findAll(page);
    }
    
    @GetMapping("/api/kelurahan/{id}")
    @ResponseBody
    public Kelurahan cariKelurahanById(@PathVariable(name = "id") Kelurahan k){
        return k;
    }
    
    @PostMapping("/api/kelurahan")
    @ResponseStatus(HttpStatus.CREATED)
    public void simpan(@RequestBody @Valid Kelurahan k){
        kelurahanDao.save(k);
    }
}
