package leites.sole.twilight_petagram;

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

import leites.sole.twilight_petagram.adapter.MascotaAdaptador;
import leites.sole.twilight_petagram.menues.AcercaDe;
import leites.sole.twilight_petagram.menues.contactoForm;
import leites.sole.twilight_petagram.pojo.Mascotas;

public class cincoFavoritos extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
    private RecyclerView rvFavoritos;
    public MascotaAdaptador adaptador;
    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinco_favoritos);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_baseline_pets_24);
        //SetSupportActionBar(toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        rvFavoritos = (RecyclerView) findViewById(R.id.rvFavoritos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvFavoritos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

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

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        rvFavoritos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("Moyo", "14", R.drawable.oveja));
        mascotas.add(new Mascotas("Pipi", "12", R.drawable.pajaro));
        mascotas.add(new Mascotas("Eugenia","9", R.drawable.turtle));
        mascotas.add(new Mascotas("Helgua", "7", R.drawable.polarpolls));
        mascotas.add(new Mascotas("Fernan", "6", R.drawable.cangre));

    }
}

