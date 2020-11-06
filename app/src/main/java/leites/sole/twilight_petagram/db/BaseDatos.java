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
                ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES + " TEXT, " +
                ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES_ORDEN + " TEXT " +
                ")";

        db.execSQL(queryCrearTablaMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_PETS );
        onCreate(db);
    }

        //CREAR EL LISTADO TOTAL DE MASCOTAS EN MAIN
    public void insertarMascotas(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS, null, contentValues);
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
            mascotaActual.setOrden(registros.getString(4));
            mascotas.add(mascotaActual);
            if (mascotas.size() > 10){
                break;
            }
        }
        db.close();
        return mascotas;
    }

        //BLOQUE PARA ACTUALIZAR LOS LIKES POR CLIC
    public void refreshLikes(ContentValues contentValues){
        int id = contentValues.getAsInteger(ConstantesBaseDatos.TABLE_PETS_ID);
        int nLike =  contentValues.getAsInteger(ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES);
        String query = "UPDATE "+ConstantesBaseDatos.TABLE_PETS+
                " set "+ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES+" = "+nLike+", "+
                ConstantesBaseDatos.TABLE_PETS_NUMERO_LIKES_ORDEN+ "= julianday('now')"+
                "WHERE "+ConstantesBaseDatos.TABLE_PETS_ID + "="+id;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(query);
        db.close();
    }

        //BLOQUE PARA MOSTRAR LOS 5 FAVORITOS
    public ArrayList<Mascotas> losFavoritos(){
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
            mascota.setOrden(registros.getString(4));
            mascotas.add(mascota);
        }
        db.close();
        return  mascotas;

    }
}
