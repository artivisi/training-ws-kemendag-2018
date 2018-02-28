package id.go.kemendag.siup.aplikasisiup.controller;

import id.go.kemendag.siup.aplikasisiup.dao.KelurahanDao;
import id.go.kemendag.siup.aplikasisiup.entity.Kelurahan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
