package leites.sole.twilight_petagram;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import leites.sole.twilight_petagram.adapter.CincoFavoritosAdaptador;
import leites.sole.twilight_petagram.adapter.MascotaAdaptador;
import leites.sole.twilight_petagram.interfaz.ICincoFavsView;
import leites.sole.twilight_petagram.menues.AcercaDe;
import leites.sole.twilight_petagram.menues.contactoForm;
import leites.sole.twilight_petagram.pojo.Mascotas;
import leites.sole.twilight_petagram.presentador.CincoFavoritosPresenter;
import leites.sole.twilight_petagram.presentador.ICincoFavoritosPresenter;

public class cincoFavoritos extends AppCompatActivity implements ICincoFavsView {

    ArrayList<Mascotas> mascotas;
    private RecyclerView rvFavoritos;
    public CincoFavoritosAdaptador adaptador;
    Toolbar toolbar;
    Activity activity;
    private ICincoFavoritosPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinco_favoritos);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_baseline_pets_24);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvFavoritos = (RecyclerView) findViewById(R.id.rvFavoritos);

        presenter = new CincoFavoritosPresenter(this, getBaseContext());

    }

    // MENU DE OPCIONES  contacto y about
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.contacto:
                Intent j = new Intent(this, contactoForm.class);
                startActivity(j);
                break;
            case R.id.acercaDe:
                Intent k = new Intent(this, AcercaDe.class);
                startActivity(k);
                break;

        }
       return super.onOptionsItemSelected(item);
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvFavoritos.setLayoutManager(llm);

    }

    @Override
    public CincoFavoritosAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        CincoFavoritosAdaptador adaptador;
        adaptador = new CincoFavoritosAdaptador(mascotas, this);
        return adaptador;
    }


    @Override
    public void inicializarAdaptadorRV(CincoFavoritosAdaptador adaptador) {
        rvFavoritos.setAdapter(adaptador);
    }
}


