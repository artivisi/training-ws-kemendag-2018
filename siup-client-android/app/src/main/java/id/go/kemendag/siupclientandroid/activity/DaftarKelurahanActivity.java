package id.go.kemendag.siupclientandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import id.go.kemendag.siupclientandroid.R;
import id.go.kemendag.siupclientandroid.dto.Kelurahan;
import id.go.kemendag.siupclientandroid.service.SiupRestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarKelurahanActivity extends AppCompatActivity {

    private static final String TAG = "DaftarKelurahanActivity";

    private SiupRestClient siupRestClient = new SiupRestClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_kelurahan);
    }

    public void ambilData(View view) {
        Log.i(TAG, "Menjalankan method ambil data");
        siupRestClient.dataKelurahan().enqueue(new Callback<List<Kelurahan>>() {
            @Override
            public void onResponse(Call<List<Kelurahan>> call, Response<List<Kelurahan>> response) {
                Toast.makeText(DaftarKelurahanActivity.this, "Data kelurahan berhasil diambil", Toast.LENGTH_SHORT).show();
                List<Kelurahan> hasil = response.body();
                for (Kelurahan k : hasil) {
                    Log.i(TAG, "ID : "+k.getId());
                    Log.i(TAG, "Kode : "+k.getKode());
                    Log.i(TAG, "Nama : "+k.getNama());
                    Log.i(TAG, "Kodepos : "+k.getKodepos());
                }
            }

            @Override
            public void onFailure(Call<List<Kelurahan>> call, Throwable t) {
                Toast.makeText(DaftarKelurahanActivity.this, "Data kelurahan gagal diambil", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.getMessage());
                t.printStackTrace();

            }
        });
    }
}
