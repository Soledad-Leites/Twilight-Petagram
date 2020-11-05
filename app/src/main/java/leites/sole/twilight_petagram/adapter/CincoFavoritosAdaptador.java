package leites.sole.twilight_petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import leites.sole.twilight_petagram.R;
import leites.sole.twilight_petagram.pojo.Mascotas;

public class CincoFavoritosAdaptador extends RecyclerView.Adapter<CincoFavoritosAdaptador.MascotaFavoritaViewHolder> {
    ArrayList<Mascotas> mascotas;
    Activity activity;

    public CincoFavoritosAdaptador(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override
    public MascotaFavoritaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cada_vista, null, false);
        return new MascotaFavoritaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaFavoritaViewHolder holder, int position) {
        final Mascotas mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getImagen());
        holder.tvHuesoBlanco.setText(mascota.getNombre());
        holder.tvHuesoAmarillo.setText(String.valueOf(mascota.getlikes()));
        if (activity != null){
            holder.btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Mascotas mascota= mascotas.get(position);
                    mascotas.remove(position);
                    mascotas.add(position,mascota);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaFavoritaViewHolder extends RecyclerView.ViewHolder{
        public AppCompatImageView imgFoto;
        public AppCompatTextView tvHuesoBlanco, tvHuesoAmarillo;
        public ImageButton btnLike;

        public MascotaFavoritaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (AppCompatImageView) itemView.findViewById(R.id.imgFoto);
            tvHuesoBlanco = (AppCompatTextView) itemView.findViewById(R.id.tvHuesoBlanco);
            tvHuesoAmarillo = (AppCompatTextView) itemView.findViewById(R.id.tvHuesoAmarillo);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);

        }
    }
}
