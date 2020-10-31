package leites.sole.twilight_petagram.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import leites.sole.twilight_petagram.R;
import leites.sole.twilight_petagram.adapter.MascotaAdaptador;
import leites.sole.twilight_petagram.interfaz.IComunicaFragments;
import leites.sole.twilight_petagram.pojo.Mascotas;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Mascotas> mascotas;
    RecyclerView recyclerInicial;
    Activity activity;
    IComunicaFragments interfaceComunicaFragments;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_1, container, false);
        mascotas = new ArrayList<>();
        recyclerInicial = vista.findViewById(R.id.rcId);
        recyclerInicial.setLayoutManager(new LinearLayoutManager(getContext()));
        inicializarListaMascotas();
        MascotaAdaptador adapter = new MascotaAdaptador(mascotas);
        recyclerInicial.setAdapter(adapter);
        onAttach();


        return vista;
    }

    private void onAttach() {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.activity=(Activity)context;
          //  interfaceComunicaFragments= (IComunicaFragments) this.activity;
        }
    }

    private void inicializarListaMascotas() {
        mascotas.add(new Mascotas("Lolo", "2", R.drawable.tuki));
        mascotas.add(new Mascotas("Eugenia","9", R.drawable.turtle));
        mascotas.add(new Mascotas("Fernan", "6", R.drawable.cangre));
        mascotas.add(new Mascotas("Georgia","1", R.drawable.pez));
        mascotas.add(new Mascotas("Helgua", "7", R.drawable.polarpolls));
        mascotas.add(new Mascotas("Pipi", "12", R.drawable.pajaro));
        mascotas.add(new Mascotas("Moyo", "14", R.drawable.oveja));
    }
    
    


}