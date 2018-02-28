package id.go.kemendag.siup.aplikasisiupclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KelurahanController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(KelurahanController.class);
    
    @GetMapping("/kelurahan/list")
    public ModelMap daftarKelurahan(){
        return new ModelMap();
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
