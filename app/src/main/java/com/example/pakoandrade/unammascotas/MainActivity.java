package com.example.pakoandrade.unammascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Mascota 1",0,R.drawable.perro1));
        mascotas.add(new Mascota("Mascota 2",0,R.drawable.perro2));
        mascotas.add(new Mascota("Mascota 3",0,R.drawable.perro3));
        mascotas.add(new Mascota("Mascota 4",0,R.drawable.perro4));
        mascotas.add(new Mascota("Mascota 5",0,R.drawable.perro5));
        mascotas.add(new Mascota("Mascota 6",0,R.drawable.perro6));
        mascotas.add(new Mascota("Mascota 7",0,R.drawable.perro7));


        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        //Ejemplo
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //list.setLayoutManager(llm);
        //list.setAdapter( adapter );

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

        RVAdapter adapter = new RVAdapter(mascotas);
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_mascota, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            irDetalle();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void irDetalle(){
        Intent intent= new Intent(this,DetalleActivity.class);
        startActivity(intent);

    }

}
