package com.material.cortes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {
   ListView LisView;
    ArrayList<String> Listado;


    @Override
    protected void onPostResume() {
        super.onPostResume();
        CargarListado();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        LisView = (ListView) findViewById(R.id.LisView);

        CargarListado();
         LisView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Toast.makeText(Listado.this,Listado.get(position),Toast.LENGTH_SHORT).show();

                 int clave= Integer.parseInt(Listado.get(position).split(" ") [0]);
                 String nombre =Listado.get(position).split(" ")[1];
                 String apellido= Listado.get(position).split(" ")[2];
                 Intent intent =new Intent(Listado.this,Modificar.class);
                 intent.putExtra("Id",clave);
                 intent.putExtra("Nombre",nombre);
                 intent.putExtra("Apellido",apellido);
                 startActivity(intent);


             }
         });


        if(getSupportActionBar()!= null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      if (item.getItemId()==android.R.id.home){
          finish();
      }
      return super.onOptionsItemSelected(item);
    }

    private void  CargarListado(){
        Listado= ListaPersonas();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Listado);
        LisView.setAdapter(adapter);
    }

    private ArrayList<String>ListaPersonas(){
   ArrayList<String> datos= new ArrayList<String>();
        BaseHelper helper= new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql= "select Id,Nombre,Apellido from Personas";
        Cursor c = db.rawQuery(sql,null);
        if(c.moveToFirst()){
         do {
             String Linea= c.getInt(0) + "" + c.getString(1)+""+c.getString(2);
             datos.add(Linea);
         }while(c.moveToNext());
        }
        db.close();
        return datos;

    }

}