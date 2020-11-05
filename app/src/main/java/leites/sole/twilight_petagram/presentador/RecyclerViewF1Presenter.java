package leites.sole.twilight_petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import leites.sole.twilight_petagram.adapter.MascotaAdaptador;
import leites.sole.twilight_petagram.db.ConstructorMascotas;
import leites.sole.twilight_petagram.fragments.IRecyclerViewF1;
import leites.sole.twilight_petagram.pojo.Mascotas;

public class RecyclerViewF1Presenter implements IRecyclerViewF1Presenter {
    private IRecyclerViewF1 iRecyclerViewF1;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas>mascotas;

    public RecyclerViewF1Presenter(IRecyclerViewF1 iRecyclerViewF1, Context context){
        this.iRecyclerViewF1 = iRecyclerViewF1;
        this.context = context;
        obtenerMascotasBD();
        mostrarMascotasRV();
    }


    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerTodasLasMascotas();

    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewF1.inicializarAdaptadorRV(iRecyclerViewF1.crearAdaptador(mascotas));
        iRecyclerViewF1.generarLinearLayoutVertical();
    }
}
