package id.go.kemendag.siup.aplikasisiup.controller;

import id.go.kemendag.siup.aplikasisiup.dao.KelurahanDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(KelurahanApiController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class KelurahanApiControllerTests {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private KelurahanDao kelurahanDao;
   
    @Test
    public void testGetKelurahan() throws Exception {
        System.out.println("Menjalankan test ambil data kelurahan");
        this.mockMvc.perform(get("/api/kelurahan"))
                .andDo(print())
            .andExpect(status().isOk())
                
                .andDo(MockMvcRestDocumentation.document("kelurahan"));;
    }
    
}
