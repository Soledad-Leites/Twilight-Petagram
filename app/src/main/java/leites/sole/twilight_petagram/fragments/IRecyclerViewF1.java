package leites.sole.twilight_petagram.fragments;

import java.util.ArrayList;

import leites.sole.twilight_petagram.adapter.MascotaAdaptador;
import leites.sole.twilight_petagram.pojo.Mascotas;

public interface IRecyclerViewF1 {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
