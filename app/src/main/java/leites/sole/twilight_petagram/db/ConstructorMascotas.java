package leites.sole.twilight_petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import leites.sole.twilight_petagram.R;
import leites.sole.twilight_petagram.pojo.Mascotas;

public class ConstructorMascotas {

    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascotas> obtenerTodasLasMascotas() {
        BaseDatos db = new BaseDatos(context);
        insertarLasMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarLasMascotas(BaseDatos db) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Tuki");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.tuki);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES_ORDEN, " ");

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Eugenia");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.cangre);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES_ORDEN, " ");


        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Pipi");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.pajaro);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES_ORDEN, " ");

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Georgia");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.pez);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES_ORDEN, " ");

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Helgua");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.turtle);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES_ORDEN, " ");

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Moyo");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.oveja);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES_ORDEN, " ");

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Fernan");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.polarpolls);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES_ORDEN, " ");

        db.insertarMascotas(contentValues);
    }


    public void darLikeMascota(Mascotas mascota) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_ID, mascota.getId());
        mascota.suma();
        contentValues.put((ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES), (mascota.getlikes()));
        BaseDatos db = new BaseDatos(context);
        db.refreshLikes(contentValues);
    }

    public ArrayList<Mascotas> favoritos(){
        BaseDatos db = new BaseDatos(context);
        return db.losFavoritos();
    }
}
