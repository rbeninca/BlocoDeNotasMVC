package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDao {
    SQLiteDatabase db;
    public NotaDao(Context c) {
        this.db = c.openOrCreateDatabase("notas.db", Context.MODE_PRIVATE, null);
    }

    public  void insert(Nota nota) {
        ContentValues cv = new ContentValues();
        cv.put("titulo", nota.titulo);
        cv.put("txt", nota.txt);
        db.insert("notas", null, cv);
    }
    public void update(Nota nota) {
        ContentValues cv = new ContentValues();
        cv.put("titulo", nota.titulo);
        cv.put("txt", nota.txt);
        db.update("notas", cv, "id = ?", new String[]{String.valueOf(nota.id)});
    }
    public void delete(Nota nota) {
        db.delete("notas", "id = ?", new String[]{String.valueOf(nota.id)});
    }
    public Nota getNota(int id){
        String sql="SELECT * FROM notas WHERE id = ?";
        Cursor c = db.rawQuery(sql, new String[]{String.valueOf(id)});
        //Recupenado um registro relacionado e convertendo para objeto Nota
        c.moveToFirst();
        int idNota = c.getInt(c.getColumnIndex("id"));
        String titulo = c.getString(c.getColumnIndex("titulo"));
        String txt = c.getString(c.getColumnIndex("txt"));
        Nota nota = new Nota(idNota, titulo, txt);
        return nota;
    }
    public ArrayList<Nota>  getAllNotes(){
        String sql = "SELECT * FROM notas";
        ArrayList<Nota> notas = new ArrayList<>();
        Cursor c = db.rawQuery(sql, null);
        //Recuperando todos registro de notas e convertendo em um ArrayList de Notas
        c.moveToFirst();
        while (!c.isAfterLast()) {
            //Recuperando os dados de cada registro e criando um objeto Nota com os dados do registro e por fim adicionado o a lista de notas
            int id = c.getInt(c.getColumnIndex("id"));
            String titulo = c.getString(c.getColumnIndex("titulo"));
            String txt = c.getString(c.getColumnIndex("txt"));
            Nota nota = new Nota(id, titulo, txt);
            notas.add(nota);
        }
        return  notas;
    }


}
