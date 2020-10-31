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

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascotas> mascotas;
    private View.OnClickListener listener;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascotas> mascotas){ //METODO CONSTRUCTOR
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override //INFLA ELLAYOUT Y LO PASARA AL VIEWHOLDER PARA QUE OBTENGA LOS DATOS SOLICITADOS EN EL METODO onBindViewHolder
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cada_vista, null, false);
        return new MascotaViewHolder(v);
    }


    @Override //ASOCIA CADA ELEMENTO DE LA LISTA CON CADA VIEW
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {

        holder.imgFoto.setImageResource(mascotas.get(position).getImagen());
        holder.tvHuesoBlanco.setText(mascotas.get(position).getNombre());
        holder.tvHuesoAmarillo.setText(mascotas.get(position).getFavorito());
        holder.btnLike.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  Toast.makeText(activity, "Diste like a " + mascotas.get(position).getNombre(),
                          Toast.LENGTH_SHORT).show();
              }
        });
    }

    @Override
    public int getItemCount() { //CANTIDAD DE ELEMENTOS QUE CONTIENE MI LISTA DE CONTACTOS
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        public AppCompatImageView imgFoto;
        public AppCompatTextView tvHuesoBlanco,tvHuesoAmarillo;
        public AppCompatImageButton btnLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto         = (AppCompatImageView) itemView.findViewById(R.id.imgFoto);
            tvHuesoBlanco      = (AppCompatTextView) itemView.findViewById(R.id.tvHuesoBlanco);
            tvHuesoAmarillo    = (AppCompatTextView) itemView.findViewById(R.id.tvHuesoAmarillo);
            btnLike         = (AppCompatImageButton) itemView.findViewById(R.id.btnLike);

        }
    }

}
