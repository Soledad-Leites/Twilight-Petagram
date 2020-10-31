package leites.sole.twilight_petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import leites.sole.twilight_petagram.R;
import leites.sole.twilight_petagram.pojo.Mascotas;

public class GridAdaptador extends RecyclerView.Adapter<GridAdaptador.MascotaViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;

    public GridAdaptador(ArrayList<Mascotas> mascotas){ //METODO CONSTRUCTOR
        this.mascotas = mascotas;
    }

    @NonNull
    @Override //INFLA ELLAYOUT Y LO PASARA AL VIEWHOLDER PARA QUE OBTENGA LOS DATOS SOLICITADOS EN EL METODO onBindViewHolder
    public GridAdaptador.MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_grid, null, false);
        return new GridAdaptador.MascotaViewHolder(v);

    }


    @Override //ASOCIA CADA ELEMENTO DE LA LISTA CON CADA VIEW
    public void onBindViewHolder(@NonNull final GridAdaptador.MascotaViewHolder holder, int position) {

        holder.imgFoto.setImageResource(mascotas.get(position).getImagen());
        holder.tvHuesoAmarillo.setText(mascotas.get(position).getFavorito());

    }

    @Override
    public int getItemCount() { //CANTIDAD DE ELEMENTOS QUE CONTIENE MI LISTA DE CONTACTOS
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        public AppCompatImageView imgFoto;
        public AppCompatTextView tvHuesoAmarillo;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto         = (AppCompatImageView) itemView.findViewById(R.id.imgFoto);
            tvHuesoAmarillo    = (AppCompatTextView) itemView.findViewById(R.id.tvHuesoAmarillo);

        }
    }

}

