package leites.sole.twilight_petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import leites.sole.twilight_petagram.pojo.Mascotas;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " +ConstantesBaseDatos.TABLE_PETS + "(" +
                ConstantesBaseDatos.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_PETS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_PETS_PIC + " INTEGER, " +
                ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES + " INTEGER " +
                ")";

        db.execSQL(queryCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_PETS );
        onCreate(db);
    }

    public void insertarMascotas(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS, null, contentValues);
        db.close();

    }

    public void refreshLikes(ContentValues contentValues){
        String query = "UPDATE "+ConstantesBaseDatos.TABLE_PETS+
                " set "+ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES+" = "+contentValues.getAsInteger(ConstantesBaseDatos.TABLE_PETS_ID)+", "+
                ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES_ORDEN+ "= julianday('now')"+
                "WHERE "+ConstantesBaseDatos.TABLE_PETS_ID+ "="+contentValues.getAsInteger(ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(query);
        db.close();
    }

    public ArrayList<Mascotas> obtenerTodasLasMascotas(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImagen(registros.getInt(2));
            mascotaActual.setlikes(registros.getInt(3));
            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;
    }


    public ArrayList<Mascotas> favoritos(){
        ArrayList<Mascotas> mascotas = new ArrayList<Mascotas>();
        String query = "SELECT * FROM "
                + ConstantesBaseDatos.TABLE_PETS +
                " WHERE " + ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES + " !=0 "+
                " order by "+ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES_ORDEN+
                " desc limit 5";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query,null);
        while (registros.moveToNext()){
            Mascotas mascota = new Mascotas();
            mascota.setId(registros.getInt(0));
            mascota.setNombre(registros.getString(1));
            mascota.setImagen(registros.getInt(2));
            mascota.setlikes(registros.getInt(3));
            mascota.setOrden(registros.getLong(4));
            mascotas.add(mascota);
        }
        db.close();
        return  mascotas;

    }
}
