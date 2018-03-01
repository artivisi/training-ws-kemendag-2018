package id.go.kemendag.siup.aplikasisiupclient.controller;

import id.go.kemendag.siup.aplikasisiupclient.dto.Kelurahan;
import id.go.kemendag.siup.aplikasisiupclient.service.SiupRestClient;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class KelurahanController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(KelurahanController.class);
    
    @Autowired private SiupRestClient siupRestClient;
    
    @GetMapping("/kelurahan/list")
    public ModelMap daftarKelurahan(){
        return new ModelMap()
                .addAttribute("daftarKelurahan", siupRestClient.dataKelurahan());
    }
    
    @GetMapping("/kelurahan/view")
    public ModelMap daftarKelurahan(@RequestParam(name = "id")Integer idKelurahan){
        return new ModelMap()
                .addAttribute("kelurahan", siupRestClient.cariById(idKelurahan));
    }
    
    @GetMapping("/kelurahan/form")
    public ModelMap tampilkanForm(@RequestParam(name = "id", required = false)
            Integer idKelurahan){
        
        Kelurahan k = new Kelurahan();
        
        if(idKelurahan != null){
            k = siupRestClient.cariById(idKelurahan);
            if(k == null){
                k = new Kelurahan();
            }
        }
        
        
        return new ModelMap().addAttribute("kelurahan", k);
    }
    
    @PostMapping("/kelurahan/form")
    public String prosesForm(@ModelAttribute @Valid Kelurahan k, BindingResult errors, SessionStatus sessionStatus){
        LOGGER.info("Kode : "+k.getKode());
        LOGGER.info("Nama : "+k.getNama());
        
        if(errors.hasErrors()){
            return "kelurahan/form";
        }
        
        LOGGER.info("Menyimpan data kelurahan");
        siupRestClient.simpanKelurahan(k);
        
        sessionStatus.setComplete();
        return "redirect:list";
    }
}
