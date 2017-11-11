package com.material.cortes;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }



    public  void llamar_cortes(View vista){

        Button llamar = (Button)findViewById(R.id.llamarCortes);

        Intent llamadas = new Intent(MainActivity.this,Galeria.class);
        startActivity(llamadas);

    }

    public void  Resgristrece_logib(View vista){

        Button Re =(Button)findViewById(R.id.registro);


        Intent mg = new Intent(MainActivity.this,Registro.class);
        startActivity(mg);
    }

    public void  Resservas(View vista){

        Button reserva =(Button)findViewById(R.id.Reserver);


        Intent mg = new Intent(MainActivity.this,Reservaciones.class);
        startActivity(mg);
    }

}
