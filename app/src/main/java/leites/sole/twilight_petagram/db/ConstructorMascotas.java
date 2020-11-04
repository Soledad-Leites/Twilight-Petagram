package leites.sole.twilight_petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import leites.sole.twilight_petagram.R;
import leites.sole.twilight_petagram.pojo.Mascotas;

public class ConstructorMascotas {
    private static final Integer LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascotas> obtenerdatos() {
        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);

        return db.obtenerTodasLasMascotas();
    }

    public void insertarTresMascotas(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Lolo");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.tuki);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Eugenia");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.cangre);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Pipi");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.pajaro);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Georgia");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.pez);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Helgua");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.turtle);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Moyo");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.oveja);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Fernan");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PIC, R.drawable.polarpolls);

        db.insertarMascotas(contentValues);
    }


    public void darLikeMascota(Mascotas mascota) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES, LIKE);
        db.refreshLikes(contentValues);
    }

    public ArrayList<Mascotas> favoritos(){
        BaseDatos db = new BaseDatos(context);
        return db.favoritos();
    }
}
