package com.example.usuario.examenandroidmanuelluque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class Modificar_Activity extends AppCompatActivity {
    ArrayList<String> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_modificar_);

        EditText nombre=(EditText) findViewById(R.id.enombre);


    }
}
