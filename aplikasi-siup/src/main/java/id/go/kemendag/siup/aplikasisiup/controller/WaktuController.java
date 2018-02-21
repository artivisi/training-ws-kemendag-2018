package id.go.kemendag.siup.aplikasisiup.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WaktuController {
    
    @GetMapping("/waktu")
    @ResponseBody
    public String sekarang(){
        SimpleDateFormat formatterWaktu = new SimpleDateFormat("EEEE, dd MMMM yyyy", new Locale("id", "ID"));
        return formatterWaktu.format(new Date());
    }
    
    @GetMapping("/appinfo")
    @ResponseBody
    public Map<String, String> info(@RequestParam String nama){
        Map<String, String> data = new LinkedHashMap<>();
        
        data.put("application.name", "Aplikasi SIUP");
        data.put("application.version", "1.0.0");
        data.put("last.update", "2018-01-01");
        data.put("author", nama);
        
        return data;
    }
}
