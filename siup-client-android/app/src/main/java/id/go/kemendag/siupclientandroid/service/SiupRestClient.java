package id.go.kemendag.siupclientandroid.service;

import java.util.List;

import id.go.kemendag.siupclientandroid.dto.Kelurahan;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SiupRestClient {

    private SiupRetrofit siupRetrofit;

    public SiupRestClient(){
        String API_BASE_URL = "https://siup-server.herokuapp.com";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();

        siupRetrofit = retrofit.create(SiupRetrofit.class);
    }

    public Call<List<Kelurahan>> dataKelurahan() {
        return siupRetrofit.dataKelurahan();
    }
}
