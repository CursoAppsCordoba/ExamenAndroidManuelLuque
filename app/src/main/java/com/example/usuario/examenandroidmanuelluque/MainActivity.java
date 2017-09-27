package com.example.usuario.examenandroidmanuelluque;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Set<Contactos> lista;
    public static final int ALTA = 100;
    public static final int BAJA = 200;
    public static final int LISTAR = 300;
    TextView totalcontact;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalcontact =(TextView) findViewById(R.id.totalcontactos);
        Button btnAlta = (Button) findViewById(R.id.alta);
        btnAlta.setOnClickListener(this);
        Button btnBaja = (Button) findViewById(R.id.baja);
        btnBaja.setOnClickListener(this);
        Button btnLista = (Button) findViewById(R.id.listar);
        btnLista.setOnClickListener(this);
        lista = new HashSet<>();




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alta:
                Intent intent = new Intent(this, Alta_Activity.class);
                startActivityForResult(intent, ALTA);
                break;
            case R.id.baja:
                Intent intent2 = new Intent(this, Baja_Activity.class);
                startActivityForResult(intent2, BAJA);
                break;
            case R.id.listar:
                Intent intent3 = new Intent(this, Listar_Activity.class);
                intent3.putExtra("lista", new ArrayList<>(lista));
                startActivityForResult(intent3, LISTAR);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case ALTA:
                if (resultCode == Activity.RESULT_OK) {
                    if (data.hasExtra("contactos")) {
                        lista.add((Contactos) data.getParcelableExtra("contactos"));
                    }
                }
                break;



            case BAJA:
                if (resultCode == RESULT_OK) {
                    if (data.hasExtra("contactos")) {
                        if (lista.remove(data.getParcelableExtra("contactos"))) {
                            Toast.makeText(this.getApplicationContext(), "Contacto eliminado", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this.getApplicationContext(), "No se ha eliminado", Toast.LENGTH_SHORT).show();
                        }

                    }
                    break;
                }
        }
        totalcontact.setText("Cantidad de contactos: " + lista.size());
    }
}