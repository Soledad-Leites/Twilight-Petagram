package leites.sole.twilight_petagram.interfaz;

import java.util.ArrayList;

import leites.sole.twilight_petagram.adapter.CincoFavoritosAdaptador;
import leites.sole.twilight_petagram.pojo.Mascotas;

public interface ICincoFavsView {

    public void generarLinearLayoutVertical();
    public CincoFavoritosAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);
    public void inicializarAdaptadorRV(CincoFavoritosAdaptador adaptador);

}
