package com.example.pakoandrade.unammascotas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {

    ImageView imagenDerecha;
    ImageView iconoHueso;
    ArrayList mascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Mascota 3", 10, R.drawable.perro3));
        mascotas.add(new Mascota("Mascota 1", 8, R.drawable.perro1));
        mascotas.add(new Mascota("Mascota 7", 5, R.drawable.perro7));
        mascotas.add(new Mascota("Mascota 4", 4, R.drawable.perro4));
        mascotas.add(new Mascota("Mascota 5", 1, R.drawable.perro5));


        RecyclerView rv = (RecyclerView)findViewById(R.id.rv_detalle);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        rv.setClickable(false);
        rv.setEnabled(false);
        rv.setLayoutFrozen(true);
        rv.setItemAnimator(new DefaultItemAnimator());
        RVAdapter adapter = new RVAdapter(mascotas);//paso listado al adaptador
        rv.setAdapter(adapter);
    }

}
