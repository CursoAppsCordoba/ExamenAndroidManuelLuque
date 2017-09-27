package com.example.usuario.examenandroidmanuelluque;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Listar_Activity extends AppCompatActivity implements View.OnClickListener{

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<String> lista;
    private AlertDialog ventana;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_);
        listView=(ListView) findViewById(R.id.lista1);
        final ArrayList<String> lista = (ArrayList<String>) getIntent().getSerializableExtra("lista");
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Log.i("Click", "click en el elemento " + position + " de mi ListView");

                muestraDialogo();

            }
        });
        Button botonvolver=(Button) findViewById(R.id.btnVolver);
        botonvolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

                    if (ventana == null) {
                        ventana = CreateDialog(v);
                    }
                    ventana.show();




        }

    private void muestraDialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Deseas editar el contacto?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       Intent intent=new Intent(Listar_Activity.this, Modificar_Activity.class);

                        startActivityForResult(intent,0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public AlertDialog CreateDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Quieres ir al menu?");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               Listar_Activity.this.finish();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }




}

