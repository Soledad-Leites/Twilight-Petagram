package leites.sole.twilight_petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import leites.sole.twilight_petagram.db.ConstructorMascotas;
import leites.sole.twilight_petagram.interfaz.ICincoFavsView;
import leites.sole.twilight_petagram.pojo.Mascotas;

public class CincoFavoritosPresenter implements ICincoFavoritosPresenter{
        private ICincoFavsView iCincoFavsView;
        private Context context;
        private ConstructorMascotas constructorMascotas;
        private ArrayList<Mascotas> mascotas;

        public CincoFavoritosPresenter(ICincoFavsView iCincoFavsView, Context context){
            this.iCincoFavsView = iCincoFavsView;
            this.context = context;
            obtenerMascotasBD();
        }


        @Override
        public void obtenerMascotasBD() {
            constructorMascotas = new ConstructorMascotas(context);
            mascotas = constructorMascotas.obtenerTodasLasMascotas();
            mostrarMascotasRV();
        }

        @Override
        public void mostrarMascotasRV() {
            iCincoFavsView.inicializarAdaptadorRV(iCincoFavsView.crearAdaptador(mascotas));
            iCincoFavsView.generarLinearLayoutVertical();
        }
    }

