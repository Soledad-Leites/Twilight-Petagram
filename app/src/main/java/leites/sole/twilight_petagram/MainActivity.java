package leites.sole.twilight_petagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import leites.sole.twilight_petagram.adapter.PageAdapter;
import leites.sole.twilight_petagram.fragments.Fragment1;
import leites.sole.twilight_petagram.fragments.Fragment2;
import leites.sole.twilight_petagram.menues.AcercaDe;
import leites.sole.twilight_petagram.menues.contactoForm;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public PageAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_baseline_pets_24);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_house_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_pets_24);
    }

    /**/
    // MENU DE OPCIONES ** ESTRELLA EN EL APPBAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ambos, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.estrellita:
                Intent intent = new Intent(this, cincoFavoritos.class);
                startActivity(intent);
                break;
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

}




