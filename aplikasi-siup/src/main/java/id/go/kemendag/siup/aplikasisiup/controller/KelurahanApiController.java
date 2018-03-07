package id.go.kemendag.siup.aplikasisiup.controller;

import id.go.kemendag.siup.aplikasisiup.dao.KelurahanDao;
import id.go.kemendag.siup.aplikasisiup.entity.Kelurahan;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class KelurahanApiController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(KelurahanApiController.class);
    
    @Autowired
    private KelurahanDao kelurahanDao;
    
    @GetMapping("/api/kelurahan")
    @ResponseBody
    public List<Kelurahan> dataKelurahan(){
        System.out.println("Mencari data kelurahan");
        List<Kelurahan> data = new ArrayList<>();
        Kelurahan k = new Kelurahan();
        k.setId(100);
        k.setKode("K099");
        k.setNama("Kelurahan 99");
        k.setKodepos("123");
        data.add(k);
              
        return data;
        //return kelurahanDao.findAll(page).getContent();
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
    
    @PutMapping("/api/kelurahan/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Integer id, 
            @RequestBody @Valid Kelurahan input){
        
        Kelurahan dariDatabase = kelurahanDao.findOne(id);
        
        if(dariDatabase == null) {
            LOGGER.warn("Kelurahan dengan id {} tidak ada di database", id);
            return;
        }
        
        BeanUtils.copyProperties(input, dariDatabase);
        dariDatabase.setId(id);
        kelurahanDao.save(dariDatabase);
    }
    
    @DeleteMapping("/api/kelurahan/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void hapus(@PathVariable("id") Kelurahan k){
        if(k != null){
            kelurahanDao.delete(k);
        }
    }
}
