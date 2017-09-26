package com.example.usuario.examenandroidmanuelluque;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Baja_Activity extends AppCompatActivity implements View.OnClickListener {

    private Contactos contactos;
    private AlertDialog ventana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baja_);
        Button btnbaja = (Button) findViewById(R.id.btbaja);
        btnbaja.setOnClickListener(this);
        Button btncancelar = (Button) findViewById(R.id.btcancelar);
        btncancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btbaja:
                contactos = eliminarContacto(v);
                if (contactos != null) {
                    Intent intent = new Intent();
                    intent.putExtra("contactos", contactos);
                    setResult(RESULT_OK, intent);
                }
                finish();
                break;

            case R.id.btcancelar:
                if (ventana == null) {
                    ventana = CreateDialog(v);
                }
                ventana.show();

                break;
        }

    }

    public AlertDialog CreateDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Quieres ir al menu?");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Baja_Activity.this.finish();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }


    public Contactos eliminarContacto(View v) {
        Contactos contactos = null;
        EditText nombre1 = (EditText) findViewById(R.id.bnombre);
        EditText email1 = (EditText) findViewById(R.id.bemail);
        EditText edad1 = (EditText) findViewById(R.id.bedad);
        String nombre = nombre1.getText().toString();
        String email = email1.getText().toString();

        if (edad1.getText().toString().equals("")) {
            Toast.makeText(this, "No guarda sin edad", Toast.LENGTH_LONG).show();
        } else {
            Integer edad = Integer.parseInt(edad1.getText().toString());
            contactos = new Contactos(nombre, email, edad);
        }
        return contactos;
    }
}
