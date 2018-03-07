package id.go.kemendag.siupclientandroid.service;

import java.util.List;

import id.go.kemendag.siupclientandroid.dto.Kelurahan;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SiupRetrofit {
    @GET("/api/kelurahan")
    Call<List<Kelurahan>> dataKelurahan();
}
