package id.go.kemendag.siupclientandroid.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.go.kemendag.siupclientandroid.R;
import id.go.kemendag.siupclientandroid.dto.Kelurahan;

public class KelurahanAdapter extends RecyclerView.Adapter<KelurahanAdapter.KelurahanViewHolder> {

    private List<Kelurahan> dataKelurahan;

    public KelurahanAdapter(List<Kelurahan> dataKelurahan) {
        this.dataKelurahan = dataKelurahan;
    }

    @Override
    public KelurahanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.kelurahan_view, parent, false);
        return new KelurahanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KelurahanViewHolder holder, int position) {
        holder.tvKode.setText(dataKelurahan.get(position).getKode());
        holder.tvNama.setText(dataKelurahan.get(position).getNama());
        holder.tvKodepos.setText(dataKelurahan.get(position).getKodepos());
    }

    @Override
    public int getItemCount() {
        return (dataKelurahan != null) ? dataKelurahan.size() : 0;
    }

    public class KelurahanViewHolder extends RecyclerView.ViewHolder{

        private TextView tvKode;
        private TextView tvNama;
        private TextView tvKodepos;

        public KelurahanViewHolder(View itemView) {
            super(itemView);
            tvKode = itemView.findViewById(R.id.tvKode);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvKodepos = itemView.findViewById(R.id.tvKodepos);
        }
    }
}
