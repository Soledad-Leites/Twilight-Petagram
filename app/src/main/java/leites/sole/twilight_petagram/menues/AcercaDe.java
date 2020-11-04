package leites.sole.twilight_petagram.menues;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import leites.sole.twilight_petagram.R;

public class AcercaDe extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerca_de);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_baseline_pets_24);
        //SetSupportActionBar(toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
