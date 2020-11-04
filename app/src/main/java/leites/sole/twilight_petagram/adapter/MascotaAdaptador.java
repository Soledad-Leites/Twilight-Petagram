package leites.sole.twilight_petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import leites.sole.twilight_petagram.R;
import leites.sole.twilight_petagram.db.ConstructorMascotas;
import leites.sole.twilight_petagram.pojo.Mascotas;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascotas> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascotas> mascotas, Activity activity) { //METODO CONSTRUCTOR
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    //INFLA ELLAYOUT Y LO PASARA AL VIEWHOLDER PARA QUE OBTENGA LOS DATOS SOLICITADOS EN EL METODO onBindViewHolder
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cada_vista, null, false);
        return new MascotaViewHolder(v);
    }


    @Override //ASOCIA CADA ELEMENTO DE LA LISTA CON CADA VIEW
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getImagen());
        mascotaViewHolder.tvHuesoBlanco.setText(mascota.getNombre());
        mascotaViewHolder.tvHuesoAmarillo.setText(String.valueOf(mascota.getlikes()) + " Likes");
        mascotaViewHolder.btnLike.setOnClickListener(v -> {
            ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
            constructorMascotas.darLikeMascota(mascota);
            mascotaViewHolder.tvHuesoAmarillo.setText(String.valueOf(mascota.getlikes()) + " Likes");
        });

    }

        @Override
        public int getItemCount () { //CANTIDAD DE ELEMENTOS QUE CONTIENE MI LISTA DE CONTACTOS
            return mascotas.size();
        }


        public static class MascotaViewHolder extends RecyclerView.ViewHolder {

            public AppCompatImageView imgFoto;
            public AppCompatTextView tvHuesoBlanco, tvHuesoAmarillo;
            public ImageButton btnLike;

            public MascotaViewHolder(@NonNull View itemView) {
                super(itemView);
                imgFoto = (AppCompatImageView) itemView.findViewById(R.id.imgFoto);
                tvHuesoBlanco = (AppCompatTextView) itemView.findViewById(R.id.tvHuesoBlanco);
                tvHuesoAmarillo = (AppCompatTextView) itemView.findViewById(R.id.tvHuesoAmarillo);
                btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);

            }
        }

    }

