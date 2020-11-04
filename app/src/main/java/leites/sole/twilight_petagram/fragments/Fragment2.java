package leites.sole.twilight_petagram.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import leites.sole.twilight_petagram.R;
import leites.sole.twilight_petagram.adapter.GridAdaptador;
import leites.sole.twilight_petagram.adapter.MascotaAdaptador;
import leites.sole.twilight_petagram.pojo.Mascotas;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Mascotas> mascotas;
    Activity activity;
    RecyclerView rcDetalle;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
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
        View vista = inflater.inflate(R.layout.fragment_2,  container, false);
        mascotas = new ArrayList<>();
        rcDetalle = vista.findViewById(R.id.rcDetalle);
        rcDetalle.setLayoutManager((new GridLayoutManager(getContext(), 2)));
        inicializarListaMascotas();
        GridAdaptador adapter = new GridAdaptador(mascotas);
        rcDetalle.setAdapter(adapter);

       /* Bundle objetoMascota= getArguments();
        Mascotas mascota = null;

        if (objetoMascota != null){
            mascota=(Mascotas) objetoMascota.getSerializable("objeto");

        }*/
        return vista;
    }

    private void inicializarListaMascotas() {
        mascotas.add(new Mascotas( 22, R.drawable.oveja2));
        mascotas.add(new Mascotas(19, R.drawable.oveja3));
        mascotas.add(new Mascotas( 16, R.drawable.oveja4));
        mascotas.add(new Mascotas(11, R.drawable.oveja5));
        mascotas.add(new Mascotas(7, R.drawable.oveja));

    }
}