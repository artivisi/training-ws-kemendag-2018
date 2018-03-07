package id.go.kemendag.siupclientandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import id.go.kemendag.siupclientandroid.R;

public class DaftarKelurahanActivity extends AppCompatActivity {
    private static final String TAG = "DaftarKelurahanActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_kelurahan);
    }

    public void ambilData(View view) {
        Log.i(TAG, "Menjalankan method ambil data");
    }
}
