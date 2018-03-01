package id.go.kemendag.siup.aplikasisiupclient.controller;

import id.go.kemendag.siup.aplikasisiupclient.service.SiupRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public ModelMap tampilkanForm(){
        return new ModelMap();
    }
    
    @PostMapping("/kelurahan/form")
    public String prosesForm(){
        LOGGER.info("Menyimpan data kelurahan");
        return "redirect:list";
    }
}
