package id.go.kemendag.siup.aplikasisiup.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WaktuController {
    
    @GetMapping("/waktu")
    @ResponseBody
    public String sekarang(){
        SimpleDateFormat formatterWaktu = new SimpleDateFormat("EEEE, dd MMMM yyyy", new Locale("id", "ID"));
        return formatterWaktu.format(new Date());
    }
}
