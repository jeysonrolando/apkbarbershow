package com.material.cortes;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modificar extends AppCompatActivity {
    EditText et_nombree,et_apellidoo;
    Button bt_modificarr,bt_eliminar;
 int id;
    String nombre;
    String apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

      Bundle b= getIntent().getExtras();
        if (b!=null){
           id=  b.getInt("Id");
            nombre=b.getString("Nombre");
            apellido=b.getString("Apellido");
        }



        et_nombree = (EditText) findViewById(R.id.et_nombree);
        et_apellidoo = (EditText) findViewById(R.id.et_apellidoo);
        et_nombree.setText(nombre);
        et_apellidoo.setText(apellido);
        bt_modificarr = ( Button) findViewById(R.id.bt_modificarr);
        bt_eliminar = ( Button) findViewById(R.id.bt_eliminar);
        bt_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Eliminar(id);
                onBackPressed();
            }
        });

        bt_modificarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Modificar(id,et_nombree.getText().toString(),et_apellidoo.getTransitionName().toString());
                onBackPressed();
            }
        });
    }

    private void Modificar(int Id, String Nombre, String Apellido){
        BaseHelper helper= new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
       String sql= "update Personas set Nombre='" + Nombre + "',Apellido= '" + Apellido + "' where Id=" + Id;
        db.execSQL(sql);
        db.close();
    }

    private void Eliminar(int Id){
        BaseHelper helper= new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql= "delete from Personas where Id=" + Id;
        db.execSQL(sql);
        db.close();
    }
}
